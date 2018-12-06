package id.gits.gitsmvvmkotlin.mvvm.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import id.gits.gitsmvvmkotlin.data.model.Movie

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

object MainBindings {

    @BindingAdapter("app:movieList")
    @JvmStatic
    fun setMovieList(recyclerView: RecyclerView, movies: MutableLiveData<List<Movie>>) {
        try {
            with(recyclerView.adapter as MainAdapter) {
                if (movies.value?.isNotEmpty()!!) {
                    replaceData(movies.value!!)
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

}