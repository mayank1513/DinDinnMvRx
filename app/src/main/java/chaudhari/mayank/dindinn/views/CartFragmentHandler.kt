package chaudhari.mayank.dindinn.views

import chaudhari.mayank.dindinn.data.Pizza

interface CartFragmentHandler {
    fun onPizzaClicked(pizza: Pizza)
    fun onBuyBtnClicked(pizza: Pizza)
}
