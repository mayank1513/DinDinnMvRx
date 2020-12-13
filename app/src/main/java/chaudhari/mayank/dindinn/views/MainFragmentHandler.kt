package chaudhari.mayank.dindinn.views

import chaudhari.mayank.dindinn.data.Pizza

interface MainFragmentHandler {
    fun onPizzaClicked(pizza: Pizza)
    fun onBuyBtnClicked(pizza: Pizza)
    fun onCartClicked()
}
