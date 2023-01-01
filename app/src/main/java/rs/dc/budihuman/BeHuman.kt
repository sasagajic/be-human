package rs.dc.budihuman

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.facebook.flipper.core.FlipperClient
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BeHuman: Application(), ImageLoaderFactory {
    @Inject
    lateinit var flipperClient: FlipperClient

    override fun onCreate() {
        super.onCreate()

        flipperClient.start()
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this).build()
    }

}