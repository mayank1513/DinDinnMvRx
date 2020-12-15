package chaudhari.mayank.dindinn.views

import android.widget.Button
import chaudhari.mayank.dindinn.data.Item

interface PizzaItemHandler: ViewHandler {
    fun onPizzaClicked(pizza: Item)
    fun onBuyBtnClicked(pizza: Item, button: Button)
}
