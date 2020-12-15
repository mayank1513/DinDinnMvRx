package chaudhari.mayank.dindinn

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Uninitialized
import chaudhari.mayank.dindinn.data.Item
import com.airbnb.mvrx.MvRxState

data class PizzaState(
    val pizzas: Async<List<Item>> = Uninitialized,
    val tikkis: Async<List<Item>> = Uninitialized,
    val drinks: Async<List<Item>> = Uninitialized,
    val cart: IntArray = intArrayOf(0, 0)
) : MvRxState {
    fun pizza(pizzaId: Long?): Item? = pizzas()?.firstOrNull { it.id == pizzaId }
    fun tikki(tikkiId: Long?): Item? = tikkis()?.firstOrNull { it.id == tikkiId }
    fun drink(tikkiId: Long?): Item? = drinks()?.firstOrNull { it.id == tikkiId }
//    fun getCart() = pizzas()?.filter { it -> it.inCart > 0 }
//    fun getAll():List<Pizza>? = pizzas()?.filter { true }
}
