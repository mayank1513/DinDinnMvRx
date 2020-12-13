package chaudhari.mayank.dindinn

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import chaudhari.mayank.dindinn.data.Pizza
import chaudhari.mayank.dindinn.databinding.PizzaRowBinding
import chaudhari.mayank.dindinn.utils.LayoutViewHolder
import chaudhari.mayank.dindinn.views.MainFragmentHandler
import chaudhari.mayank.dindinn.views.HashItemCallback

class PizzaViewHolder(parent: ViewGroup) : LayoutViewHolder(parent, R.layout.pizza_row) {
    val binding = PizzaRowBinding.bind(itemView)
}

class PizzaAdapter(private val fragment: MainFragmentHandler) : ListAdapter<Pizza, PizzaViewHolder>(HashItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(parent).apply {
            binding.handler = fragment
        }
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.binding.pizza = getItem(position)
    }
}
