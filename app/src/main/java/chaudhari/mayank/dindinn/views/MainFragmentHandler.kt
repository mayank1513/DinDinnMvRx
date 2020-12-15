package chaudhari.mayank.dindinn.views

import chaudhari.mayank.dindinn.data.Item

interface MainFragmentHandler {
    fun onPizzaClicked(pizza: Item)
    fun onBuyBtnClicked(pizza: Item)
    fun onCartClicked()
}
