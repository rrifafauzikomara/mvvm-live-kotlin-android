package id.gits.gitsmvvmkotlin.mvvm.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.gits.gitsmvvmkotlin.R
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.databinding.MainItemBinding

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

class MainAdapter(private var movies: List<Movie>, private var mainViewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val item = movies[position]

        val userActionListener = object : MainItemUserActionListener {
            override fun onMovieClicked(movie: Movie) {
                mainViewModel.openDetailMovie.value = movie
            }
        }

        (holder as MainItemHolder).bindItem(item, userActionListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mainItemBinding: MainItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent!!.context),
                R.layout.main_item, parent, false)

        return MainItemHolder(mainItemBinding)
    }

    override fun getItemCount(): Int = movies.size

    fun replaceData(movies: List<Movie>) {
        setList(movies)
    }

    fun setList(movies: List<Movie>) {
        this.movies = movies

        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: MainItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mainItemBinding = itemView

        fun bindItem(movie: Movie, userActionListener: MainItemUserActionListener) {
            mainItemBinding.item = movie
            mainItemBinding.userActionListener = userActionListener
            mainItemBinding.executePendingBindings()
        }
    }
}