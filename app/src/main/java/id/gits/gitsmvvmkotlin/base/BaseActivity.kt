package id.gits.gitsmvvmkotlin.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper



/**
 * Created by irfanirawansukirman on 26/01/18.
 */

open class BaseActivity : AppCompatActivity() {

    lateinit var mActiviy: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActiviy = this
    }
    //Todo attach base context calligraphy font in here

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}