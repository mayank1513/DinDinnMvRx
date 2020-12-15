package chaudhari.mayank.dindinn.data

data class Pizza(
    val id: Long,
    val title: String,
    val subTitle: String,
    val imageUrl: String,
    val description: String = "Description of Pizza....  is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    val price: Int = 45,
    val weight: Int = 200,
    val radius: Int = 35,
    val quantity: IntArray = intArrayOf(0, 0)
) : StableItem {
    override val stableId = id
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pizza

        if (id != other.id) return false
        if (stableId != other.stableId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + stableId.hashCode()
        return result
    }
}
