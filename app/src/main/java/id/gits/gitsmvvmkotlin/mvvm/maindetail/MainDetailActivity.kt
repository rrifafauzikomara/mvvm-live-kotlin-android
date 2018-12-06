package id.gits.gitsmvvmkotlin.mvvm.maindetail

import android.os.Build
import android.os.Bundle
import android.view.View
import id.gits.gitsmvvmkotlin.R
import id.gits.gitsmvvmkotlin.base.BaseActivity
import id.gits.gitsmvvmkotlin.util.obtainViewModel


class MainDetailActivity : BaseActivity() {

    private lateinit var viewModel: MainDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_detail_activity)

        // Hide navigation bar
        if (Build.VERSION.SDK_INT >= 19) {
            val v = window.decorView
            v.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }

        val movieId = intent.getIntExtra("movieId", 0)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainDetailFragment.newInstance(movieId))
                    .commitNow()
        }

        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel().apply {  }
    }

    fun obtainViewModel(): MainDetailViewModel = obtainViewModel(MainDetailViewModel::class.java)
}