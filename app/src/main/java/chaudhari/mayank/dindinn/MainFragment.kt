package chaudhari.mayank.dindinn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import chaudhari.mayank.dindinn.data.Pizza
import chaudhari.mayank.dindinn.databinding.MainFragmentBinding
import chaudhari.mayank.dindinn.views.MainFragmentHandler
import com.airbnb.mvrx.MvRxView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.concurrent.schedule

class MainFragment : Fragment(), MvRxView, MainFragmentHandler {

    private val viewModel: PizzaViewModel by activityViewModel()
    private lateinit var bindings: MainFragmentBinding
    private val adapter = PizzaAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = MainFragmentBinding.inflate(inflater, container, false)
        bindings.pizzasRecyclerView.adapter = adapter
        bindings.handler = this
        return bindings.root
    }

    override fun onPizzaClicked(pizza: Pizza) {
        findNavController().navigate(
            R.id.action_pizzas_to_pizzaDetail,
            PizzaDetailFragment.arg(pizza.id)
        )
    }

    var timer: Timer? = null
    override fun onBuyBtnClicked(pizza: Pizza) {
        pizza.quantity++
        pizza.inCart++
        bindings.state!!.cart[0]++
        bindings.state!!.cart[1] += pizza.price
        timer?.cancel()
        timer = Timer("reset", false)
        timer!!.schedule(1000) {
            pizza.quantity = 0;
            activity?.runOnUiThread {
                adapter.notifyDataSetChanged()
                invalidate()
            }
        }
        adapter.notifyDataSetChanged()
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
