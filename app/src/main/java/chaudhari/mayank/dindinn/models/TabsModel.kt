package chaudhari.mayank.dindinn.models

import android.view.View
import chaudhari.mayank.dindinn.R
import chaudhari.mayank.dindinn.data.Pizza
import chaudhari.mayank.dindinn.databinding.PizzaRowBinding
import chaudhari.mayank.dindinn.databinding.TabHeadersBinding
import chaudhari.mayank.dindinn.views.MainFragmentHandler
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.tab_headers)
abstract class TabsModel : EpoxyModelWithHolder<TabsModel.Holder>() {

    @EpoxyAttribute
    var activeTab: Int = 0

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(activeTab) {
            holder.binding.activeTab = activeTab
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: TabHeadersBinding
        override fun bindView(itemView: View) {
            binding = TabHeadersBinding.bind(itemView)
        }
    }
}