package chaudhari.mayank.dindinn

//import chaudhari.mayank.dindinn.utils.pizzaItemModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import chaudhari.mayank.dindinn.data.Pizza
import chaudhari.mayank.dindinn.data.Slide
import chaudhari.mayank.dindinn.databinding.MainFragmentBinding
import chaudhari.mayank.dindinn.models.CarouselItemModel_
import chaudhari.mayank.dindinn.models.PizzaViewModel
import chaudhari.mayank.dindinn.models.pizzaItem
import chaudhari.mayank.dindinn.models.tabs
import chaudhari.mayank.dindinn.views.MainFragmentHandler
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyVisibilityTracker
import com.airbnb.epoxy.carousel
import com.airbnb.mvrx.*
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.concurrent.schedule

class MainFragment : Fragment(), MvRxView, MainFragmentHandler {

    private val viewModel: PizzaViewModel by activityViewModel()
    private lateinit var bindings: MainFragmentBinding

    //    private val adapter = PizzaAdapter(this)
    private val controller = HomeController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = MainFragmentBinding.inflate(inflater, container, false)
//        bindings.pizzasRecyclerView.adapter = adapter
        bindings.handler = this

        val epoxyVisibilityTracker = EpoxyVisibilityTracker()
        epoxyVisibilityTracker.setPartialImpressionThresholdPercentage(70)
        epoxyVisibilityTracker.attach(bindings.pizzasRecyclerView)

        bindings.pizzasRecyclerView.setController(controller)
        controller.handler = this
//        controller.allPizzas = bindings.state?.getAll()
        Timer("epoxy", false).schedule(1000) {
            activity?.runOnUiThread {
                controller.pizzas = bindings.state?.pizzas
            }
        }
        return bindings.root
    }

    class HomeController : EpoxyController() {
        //        var state: PizzaState? = PizzaState()
        var pizzas: Async<List<Pizza>>? = Uninitialized
            //        var allPizzas: List<Pizza>? = emptyList()
            set(value) {
                field = value
                requestModelBuild()
            }
        lateinit var handler: MainFragmentHandler
        val slides = listOf(
            Slide(0, "Monday Discount"),
            Slide(1, "Tuesday Discount"),
            Slide(2, "Wednesday Discount")
        ).map {
            CarouselItemModel_().id(it.id).slide(it)
        }

        override fun buildModels() {
//            headerItem {
//                id("all_messages")
//                title("All Messages")
//            }

            carousel {
                id("hero")
                hasFixedSize(true)
                padding(Carousel.Padding.dp(0, 0, 0, 0, 0))
                models(slides)
            }
            tabs{
                id("tabs")
                activeTab(0)
            }
            pizzas?.invoke().orEmpty().forEach {
                pizzaItem {
                    id(it.id)
                    pizza(it)
                    handler(handler)
                }
            }
//            allPizzas?.forEach {
//
//            }
        }
    }

    override fun onPizzaClicked(pizza: Pizza) {
        findNavController().navigate(
            R.id.action_pizzas_to_pizzaDetail,
            PizzaDetailFragment.arg(pizza.id)
        )
    }

    private var timer: Timer? = null
    override fun onBuyBtnClicked(pizza: Pizza) {
        pizza.quantity[0]++
        pizza.quantity[1]++
        bindings.state!!.cart[0]++
        bindings.state!!.cart[1] += pizza.price
        timer?.cancel()
        timer = Timer("reset", false)
        timer!!.schedule(1000) {
            pizza.quantity[0] = 0
            activity?.runOnUiThread {
//        adapter.notifyDataSetChanged()
                controller.requestModelBuild()
                invalidate()
            }
        }
        controller.requestModelBuild()
//        controller.pizzas = bindings.state?.pizzas
//        adapter.notifyDataSetChanged()
        invalidate()
    }

    override fun onCartClicked() {
//        findNavController().navigate(
//            R.id.action_pizzas_to_cart
//        )
        Snackbar.make(
            bindings.root, "Coming Soon!",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun invalidate() = withState(viewModel) { state ->
        bindings.state = state
    }
}
