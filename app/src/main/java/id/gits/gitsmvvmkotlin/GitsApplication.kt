package id.gits.gitsmvvmkotlin

import android.app.Application
import com.facebook.stetho.Stetho
import uk.co.chrisjenx.calligraphy.CalligraphyConfig



/**
 * Created by irfanirawansukirman on 26/01/18.
 */

class GitsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Debug (bridge) tools
        Stetho.initializeWithDefaults(this)

        // Custom font
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Raleway-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}