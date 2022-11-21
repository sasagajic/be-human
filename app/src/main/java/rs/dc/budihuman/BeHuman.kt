package rs.dc.budihuman

import android.app.Application
import com.facebook.flipper.core.FlipperClient
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BeHuman: Application() {
    @Inject
    lateinit var flipperClient: FlipperClient

    override fun onCreate() {
        super.onCreate()

        flipperClient.start()
    }

}