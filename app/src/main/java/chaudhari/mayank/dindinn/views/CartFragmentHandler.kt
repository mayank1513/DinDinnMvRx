package chaudhari.mayank.dindinn.views

import chaudhari.mayank.dindinn.data.Item

interface CartFragmentHandler {
    fun onPizzaClicked(pizza: Item)
    fun onBuyBtnClicked(pizza: Item)
}
