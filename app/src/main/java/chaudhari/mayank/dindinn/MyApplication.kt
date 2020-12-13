package chaudhari.mayank.dindinn

import android.app.Application
import com.airbnb.mvrx.Mavericks
import chaudhari.mayank.dindinn.data.PizzaRepository

/**
 * Launcher icon made by Freepik at flaticon.com.
 */
class MyApplication : Application() {
    val pizzasRepository = PizzaRepository()

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }
}
