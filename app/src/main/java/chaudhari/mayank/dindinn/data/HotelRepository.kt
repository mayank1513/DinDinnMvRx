@file:Suppress("Detekt.MaxLineLength")

package chaudhari.mayank.dindinn.data

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class HotelRepository {
    fun getpizzas() = Observable.fromCallable<List<Item>> {
        Thread.sleep(200)
        listOf(
            Item(
                44365525,
                "Awesome Pizza",
                "Some short description goes here...",
                "https://images.unsplash.com/photo-1513104890138-7c749659a591?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8cGl6emF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
                "This pizza is really delicious and made from so and so and so items and very tasty and bla bla... some stuff goes here..... basically a long description and some meaning less test",
                46
            ),
            Item(
                40037002,
                "Pizza 2",
                "enough is enough...",
                "https://images.unsplash.com/photo-1574126154517-d1e0d89ef734?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8cGl6emF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
            ),
            Item(
                39936816,
                "Pizza 3",
                "Go get something else",
                "https://images.unsplash.com/photo-1606674727310-6d55b6960d8f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTl8fHBpenphJTIwaW5kaWF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
            ),
            Item(
                40379134,
                "Pizza 4",
                "Eat me...",
                "https://images.unsplash.com/photo-1520201163981-8cc95007dd2a?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTB8fHBpenphfGVufDB8fDB8&auto=format&fit=crop&w=600&q=60",
                "She is named after an ancient civilization, but there is nothing old and stuffy about this active girl. Meet Maya, a bouncy girl who is loaded with love and energy. Maya loves being active and she will always be ready to take you up on an offer to go for a walk. She will hope you bring a ball along with you since she is quite fond of chasing them. She is super affectionate and she loves getting treats. Maya needs to live in an active household where she can get lots of exercise. Come by and toss some balls around with Maya today.",
                70
            ),
            Item(
                40706214,
                "Pizza 5",
                "I am best",
                "https://images.unsplash.com/photo-1584365685547-9a5fb6f3a70c?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTJ8fHBpenphfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
            ),
            Item(
                39822990,
                "Pizza 6",
                "I am sweet...",
                "https://images.unsplash.com/photo-1585333783446-7fd4ede71678?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8cGl6emElMjBpbmRpYXxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
                "Have you ever wondered if there's a pizza out there that's perfect for you? Wonder no more because it's probably our handsome Wonder pizza! Wonder is his name and pondering the universal questions is his game. Ha! Wonder is a young, active, strong fellow, who prefers to take introductions slow and cautiously. He is hoping to find a forever home in a quieter, low pizza-trafficked, neighborhood with experienced adopters. Wonder loves his own people very much and isn't too keen on sharing them with others, so he is hoping to find a special someone or two someones with whom to wander through the days ahead. Why not wander down to meet Wonder today!"
            ),
            Item(
                44373538,
                "Pizza 7",
                "I am very spicy",
                "https://images.unsplash.com/photo-1573821663912-6df460f9c684?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTN8fHBpenphJTIwaW5kaWF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
            ),
            Item(
                44371030,
                "Pizza 8",
                "I am very delicious",
                "https://images.unsplash.com/photo-1604917877934-07d8d248d396?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTh8fHBpenphJTIwaW5kaWF8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
                "What's not to love about a This Pizza!",
                100
            )
        )
    }.subscribeOn(Schedulers.io())
    fun gettikkis() = Observable.fromCallable<List<Item>> {
        Thread.sleep(200)
        listOf(
            Item(
                44365525,
                "Awesome Tikki",
                "Some short description goes here...",
                "https://images.unsplash.com/photo-1567188040759-fb8a883dc6d8?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTF8fGluZGlhbiUyMGZvb2R8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=600&q=60",
                "This pizza is really delicious and made from so and so and so items and very tasty and bla bla... some stuff goes here..... basically a long description and some meaning less test",
                46
            ),
            Item(
                40037002,
                "Tikki 2",
                "enough is enough...",
                "https://upload.wikimedia.org/wikipedia/commons/d/d1/Aloo_Tikki_served_with_chutneys.jpg",
            ),
            Item(
                39936816,
                "Tikki 3",
                "Go get something else",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeCesRsXLl_pFdjhq_2YWIIh8BlTyX8vllcA&usqp=CAU",
            ),
            Item(
                40379134,
                "Spicy Tikki",
                "Eat me...",
                "https://upload.wikimedia.org/wikipedia/commons/2/24/Homemade_Aloo_Tikki.JPG",
                "She is named after an ancient civilization, but there is nothing old and stuffy about this active girl. Meet Maya, a bouncy girl who is loaded with love and energy. Maya loves being active and she will always be ready to take you up on an offer to go for a walk. She will hope you bring a ball along with you since she is quite fond of chasing them. She is super affectionate and she loves getting treats. Maya needs to live in an active household where she can get lots of exercise. Come by and toss some balls around with Maya today.",
                70
            ),
            Item(
                40706214,
                "Sweet Potato Tikki",
                "I am best",
                "https://upload.wikimedia.org/wikipedia/commons/7/7f/Aloo_Tikki_Chaat.JPG",
            ),
            Item(
                39822990,
                "Delicious",
                "I am sweet...",
                "https://upload.wikimedia.org/wikipedia/commons/4/40/Aloo_Tikki_Fried_%281%29.JPG",
                "Have you ever wondered if there's a pizza out there that's perfect for you? Wonder no more because it's probably our handsome Wonder pizza! Wonder is his name and pondering the universal questions is his game. Ha! Wonder is a young, active, strong fellow, who prefers to take introductions slow and cautiously. He is hoping to find a forever home in a quieter, low pizza-trafficked, neighborhood with experienced adopters. Wonder loves his own people very much and isn't too keen on sharing them with others, so he is hoping to find a special someone or two someones with whom to wander through the days ahead. Why not wander down to meet Wonder today!"
            ),
            Item(
                44373538,
                "Tikki 7",
                "I am very spicy",
                "https://upload.wikimedia.org/wikipedia/commons/4/49/Aloo_Tikki_stuffed_with_tangy_lentil.jpg",
            ),
//            Item(
//                44371030,
//                "Tikki 8",
//                "I am very delicious",
//                "https://upload.wikimedia.org/wikipedia/commons/c/c0/Tawa_aloo_tikki.JPG",
//                "What's not to love about a This Tikki!",
//                100
//            )
        )
    }.subscribeOn(Schedulers.io())
    fun getdrinks() = Observable.fromCallable<List<Item>> {
        Thread.sleep(200)
        listOf(
            Item(
                44365525,
                "Cola",
                "Some short description goes here...",
                "https://cdn.pixabay.com/photo/2019/05/19/18/50/drink-4214818_1280.jpg",
                "This pizza is really delicious and made from so and so and so items and very tasty and bla bla... some stuff goes here..... basically a long description and some meaning less test",
                46
            ),
            Item(
                40037002,
                "ThumbsUp",
                "enough is enough...",
                "https://pixahive.com/wp-content/uploads/2020/11/Cold-drink-209318-pixahive.jpg",
            ),
            Item(
                39936816,
                "Drink 3",
                "Go get something else",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_r8V2n_dYJRauy5Bc3WCqa3gBOP_J4LZqXw&usqp=CAU",
            ),
        )
    }.subscribeOn(Schedulers.io())
}
