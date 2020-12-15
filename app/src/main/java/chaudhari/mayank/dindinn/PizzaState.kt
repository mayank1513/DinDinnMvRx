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
//    fun getAll():List<Pizza>? = pizzas()?.filter { true }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PizzaState

        if (pizzas != other.pizzas) return false
        if (!cart.contentEquals(other.cart)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pizzas.hashCode()
        result = 31 * result + cart.contentHashCode()
        return result
    }
}
