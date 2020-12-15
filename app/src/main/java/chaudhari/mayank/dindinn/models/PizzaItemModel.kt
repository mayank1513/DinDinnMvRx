package chaudhari.mayank.dindinn.models

import android.view.View
import chaudhari.mayank.dindinn.R
import chaudhari.mayank.dindinn.data.Item
import chaudhari.mayank.dindinn.databinding.PizzaRowBinding
import chaudhari.mayank.dindinn.views.PizzaItemHandler
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.pizza_row)
abstract class PizzaItemModel : EpoxyModelWithHolder<PizzaItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var pizza: Item
    @EpoxyAttribute
    lateinit var handler: PizzaItemHandler

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(pizza) {
            holder.binding.pizza = pizza
            holder.binding.handler = handler
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: PizzaRowBinding
        override fun bindView(itemView: View) {
            binding = PizzaRowBinding.bind(itemView)
        }
    }
}