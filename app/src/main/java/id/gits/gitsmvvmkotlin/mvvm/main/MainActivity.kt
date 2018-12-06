package id.gits.gitsmvvmkotlin.mvvm.main


import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import id.gits.gitsmvvmkotlin.R
import id.gits.gitsmvvmkotlin.base.BaseActivity
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.mvvm.maindetail.MainDetailActivity
import id.gits.gitsmvvmkotlin.util.obtainViewModel
import id.gits.gitsmvvmkotlin.util.replaceFragmentInActivity
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), MainItemUserActionListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupToolbar()
        setupFragment()
        setupViewModel()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        txt_toolbar_title.text = "CGV Movie Update"
    }

    private fun setupFragment() {
        supportFragmentManager.findFragmentById(R.id.frame_main_content)
        MainFragment.newInstance().let {
            replaceFragmentInActivity(it, R.id.frame_main_content)
        }
    }

    private fun setupViewModel() {
        viewModel = obtainViewModel().apply {

            openDetailMovie.observe(this@MainActivity, Observer { movie ->
                onMovieClicked(movie!!)
            })
        }
    }

    override fun onMovieClicked(movie: Movie) {
        var intent = Intent(this@MainActivity, MainDetailActivity::class.java)
        intent.putExtra("movieId", movie.id!!)

        startActivity(intent)
    }

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)
}