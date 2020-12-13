package chaudhari.mayank.dindinn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import chaudhari.mayank.dindinn.databinding.PizzaDetailFragmentBinding
import chaudhari.mayank.dindinn.views.PizzaDetailFragmentHandler
import com.airbnb.mvrx.*

class PizzaDetailFragment : Fragment(), MvRxView, PizzaDetailFragmentHandler {

    private val viewModel: PizzaViewModel by activityViewModel()
    private val pizzaId: Long by args()

    private lateinit var binding: PizzaDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = PizzaDetailFragmentBinding.inflate(inflater, container, false)
        binding.handler = this
        return binding.root
    }

    override fun onLoveClicked() {
//        viewModel.lovepizza(pizzaId)
//        findNavController().popBackStack()
    }

    override fun invalidate() = withState(viewModel) { state ->
        binding.pizza = state.pizza(pizzaId) ?: error("Cannot find pizza with id $pizzaId")
    }

    companion object {
        fun arg(pizzaId: Long) = bundleOf(Mavericks.KEY_ARG to pizzaId)
    }
}
