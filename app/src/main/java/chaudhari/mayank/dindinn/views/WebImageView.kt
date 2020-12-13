package chaudhari.mayank.dindinn.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import chaudhari.mayank.dindinn.R
import com.squareup.picasso.Picasso

class WebImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    fun setUrl(url: String?) {
        if (url == null) {
            Picasso.get().cancelRequest(this)
            setImageDrawable(null)
            return
        }

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.logo)
            .into(this)
    }
}
