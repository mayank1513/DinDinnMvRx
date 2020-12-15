package chaudhari.mayank.dindinn.models

import android.view.View
import chaudhari.mayank.dindinn.R
import chaudhari.mayank.dindinn.data.Slide
import chaudhari.mayank.dindinn.databinding.CarouselColBinding
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder

@EpoxyModelClass(layout = R.layout.carousel_col)
abstract class CarouselItemModel : EpoxyModelWithHolder<CarouselItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var slide: Slide

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(slide) {
            holder.binding.slide = slide
        }
    }

    class Holder : EpoxyHolder() {
        lateinit var binding: CarouselColBinding
        override fun bindView(itemView: View) {
            binding = CarouselColBinding.bind(itemView)
        }
    }
}