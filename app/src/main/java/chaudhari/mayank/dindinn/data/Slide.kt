package chaudhari.mayank.dindinn.data

data class Slide(
    val id: Long,
    val title: String = "Special Discount",
    val imageUrl: String = "https://images.unsplash.com/photo-1606674727310-6d55b6960d8f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTl8fHBpenphJTIwaW5kaWF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
    val subTitle: String = "Roll as a gift to any Pizza",
) : StableItem {
    override val stableId = id
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Slide

        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
