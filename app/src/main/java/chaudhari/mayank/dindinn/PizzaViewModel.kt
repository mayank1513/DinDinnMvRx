package chaudhari.mayank.dindinn

import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import chaudhari.mayank.dindinn.data.PizzaRepository
import chaudhari.mayank.dindinn.utils.MvRxViewModel
import io.reactivex.schedulers.Schedulers

class PizzaViewModel(
    initialState: PizzaState,
    private val pizzaRepository: PizzaRepository
) : MvRxViewModel<PizzaState>(initialState) {

    init {
        pizzaRepository.getpizzas().execute { copy(pizzas = it) }
    }

    companion object : MavericksViewModelFactory<PizzaViewModel, PizzaState> {
        override fun create(viewModelContext: ViewModelContext, state: PizzaState): PizzaViewModel {
            val pizzaRepository = viewModelContext.app<MyApplication>().pizzasRepository
            return PizzaViewModel(state, pizzaRepository)
        }
    }
}
