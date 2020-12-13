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
    var quantity: Int = 0,
    var inCart: Int = 0
) : StableItem {
    override val stableId = id
}
