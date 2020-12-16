package chaudhari.mayank.dindinn

//import chaudhari.mayank.dindinn.utils.pizzaItemModel
import android.graphics.Canvas
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import chaudhari.mayank.dindinn.data.Item
import chaudhari.mayank.dindinn.data.Slide
import chaudhari.mayank.dindinn.databinding.MainFragmentBinding
import chaudhari.mayank.dindinn.models.*
import chaudhari.mayank.dindinn.views.MainFragmentHandler
import chaudhari.mayank.dindinn.views.PizzaItemHandler
import chaudhari.mayank.dindinn.views.TabHeaderHandler
import chaudhari.mayank.dindinn.views.ViewHandler
import com.airbnb.epoxy.*
import com.airbnb.mvrx.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.tab_headers.*
import java.util.*
import kotlin.concurrent.schedule

class MainFragment : Fragment(), MvRxView, MainFragmentHandler, PizzaItemHandler, TabHeaderHandler {

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
                controller.tikkis = bindings.state?.tikkis
                controller.drinks = bindings.state?.drinks
            }
        }
        EpoxyTouchHelper.initSwiping(bindings.pizzasRecyclerView).leftAndRight()
            .withTarget(PizzaItemModel_::class.java)
            .andCallbacks(object : EpoxyTouchHelper.SwipeCallbacks<PizzaItemModel_?>() {
                override fun onSwipeCompleted(
                    model: PizzaItemModel_?,
                    itemView: View?,
                    position: Int,
                    direction: Int
                ) {
                    val d = if (direction == ItemTouchHelper.LEFT) 1 else -1
                    onTabClicked((controller.activeTab + d + 3) % 3)
                    controller.requestModelBuild()
                }
            })
        return bindings.root
    }

    class HomeController : EpoxyController() {
        //        var state: PizzaState? = PizzaState()
        var pizzas: Async<List<Item>>? = Uninitialized
            set(value) {
                field = value
                requestModelBuild()
            }
        var tikkis: Async<List<Item>>? = Uninitialized
            //        var allPizzas: List<Pizza>? = emptyList()
            set(value) {
                field = value
                requestModelBuild()
            }
        var drinks: Async<List<Item>>? = Uninitialized
            //        var allPizzas: List<Pizza>? = emptyList()
            set(value) {
                field = value
                requestModelBuild()
            }
        var activeTab: Int = 0
            set(value) {
                field = value
                requestModelBuild()
            }
        lateinit var handler: ViewHandler
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
            tabs {
                id("tabs")
                activeTab(activeTab)
                handler(handler as TabHeaderHandler?)
            }
            when {
                activeTab == 0 ->
                    pizzas?.invoke().orEmpty().forEach {
                        pizzaItem {
                            id(it.id)
                            pizza(it)
                            handler(handler as PizzaItemHandler?)
                        }
                    }
                activeTab == 1 ->
                    tikkis?.invoke().orEmpty().forEach {
                        pizzaItem {
                            id(it.id.toString() + "tikki")
                            pizza(it)
                            handler(handler as PizzaItemHandler?)
                        }
                    }
                activeTab == 2 ->
                    drinks?.invoke().orEmpty().forEach {
                        pizzaItem {
                            id(it.id.toString() + "drinks")
                            pizza(it)
                            handler(handler as PizzaItemHandler?)
                        }
                    }
            }
//            allPizzas?.forEach {
//
//            }
        }
    }

    override fun onPizzaClicked(pizza: Item) {
        findNavController().navigate(
            R.id.action_pizzas_to_pizzaDetail,
            PizzaDetailFragment.arg(pizza.id)
        )
    }

    override fun onBuyBtnClicked(pizza: Item, button: Button) {
        onBuyBtnClicked(pizza)
        val n = ++pizza.quantity[0]
        button.setText("added +$n")
        button.setBackgroundResource(R.drawable.btn1)
        timer?.cancel()
        timer = Timer("reset", false)
        timer!!.schedule(1000) {
//            pizza.quantity[0] = 0
            activity?.runOnUiThread {
//        adapter.notifyDataSetChanged()
//                controller.requestModelBuild()
                val price = pizza.price
                button.setText("$price usd")
                button.setBackgroundResource(R.drawable.btn)
            }
        }
//        controller.requestModelBuild()
//        controller.pizzas = bindings.state?.pizzas
//        adapter.notifyDataSetChanged()
    }

    private var timer: Timer? = null
    override fun onBuyBtnClicked(pizza: Item) {
        pizza.quantity[1]++
        bindings.state!!.cart[0]++
        bindings.state!!.cart[1] += pizza.price
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

    override fun onTabClicked(tab: Int) {
        if (tab < 0 || tab > 2) return
        controller.activeTab = tab
        if (tabHeaders != null)
            for (i in 0..2) {
                (tabHeaders.getChildAt(i) as TextView).setTypeface(
                    null,
                    if (i == tab) Typeface.BOLD else Typeface.NORMAL
                )
            }
    }
}
