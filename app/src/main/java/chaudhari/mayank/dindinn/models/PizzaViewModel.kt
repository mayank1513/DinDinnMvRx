package chaudhari.mayank.dindinn.models

import chaudhari.mayank.dindinn.MyApplication
import chaudhari.mayank.dindinn.PizzaState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import chaudhari.mayank.dindinn.data.PizzaRepository
import chaudhari.mayank.dindinn.utils.MvRxViewModel

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
