package chaudhari.mayank.dindinn.models

import chaudhari.mayank.dindinn.MyApplication
import chaudhari.mayank.dindinn.PizzaState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import chaudhari.mayank.dindinn.data.HotelRepository
import chaudhari.mayank.dindinn.utils.MvRxViewModel

class PizzaViewModel(
    initialState: PizzaState,
    private val hotelRepository: HotelRepository
) : MvRxViewModel<PizzaState>(initialState) {

    init {
        hotelRepository.getpizzas().execute { copy(pizzas = it) }
        hotelRepository.gettikkis().execute { copy(tikkis = it) }
        hotelRepository.getdrinks().execute { copy(drinks = it) }
    }

    companion object : MavericksViewModelFactory<PizzaViewModel, PizzaState> {
        override fun create(viewModelContext: ViewModelContext, state: PizzaState): PizzaViewModel {
            val pizzaRepository = viewModelContext.app<MyApplication>().pizzasRepository
            return PizzaViewModel(state, pizzaRepository)
        }
    }
}
