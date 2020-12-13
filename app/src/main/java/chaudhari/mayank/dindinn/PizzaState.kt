package chaudhari.mayank.dindinn

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Uninitialized
import chaudhari.mayank.dindinn.data.Pizza
import com.airbnb.mvrx.MvRxState

data class PizzaState(
    val pizzas: Async<List<Pizza>> = Uninitialized,
    val cart: IntArray = intArrayOf(0, 0)
) : MvRxState {
    fun pizza(pizzaId: Long?): Pizza? = pizzas()?.firstOrNull { it.id == pizzaId }
//    fun getCart() = pizzas()?.filter { it -> it.inCart > 0 }
}
