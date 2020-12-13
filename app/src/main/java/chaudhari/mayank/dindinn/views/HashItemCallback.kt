package chaudhari.mayank.dindinn.views

import androidx.recyclerview.widget.DiffUtil
import chaudhari.mayank.dindinn.data.StableItem

class HashItemCallback<T : StableItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.hashCode() == newItem.hashCode()
}
