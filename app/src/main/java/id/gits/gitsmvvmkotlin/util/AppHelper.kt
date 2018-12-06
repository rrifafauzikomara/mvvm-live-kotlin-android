package id.gits.gitsmvvmkotlin.util

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

class AppHelper {

    object Navigation {
        fun startActivity(context: Context, destinationPage: AppCompatActivity) {
            context.startActivity(Intent(context, destinationPage::class.java))
        }
    }
}