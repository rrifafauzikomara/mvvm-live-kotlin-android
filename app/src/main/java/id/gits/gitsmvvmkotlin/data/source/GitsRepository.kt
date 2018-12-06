package id.gits.gitsmvvmkotlin.data.source

import android.util.Log
import com.google.gson.Gson
import id.gits.gitsmvvmkotlin.data.model.Movie

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

open class GitsRepository(val remoteDataSource: GitsDataSource,
                          val localDataSource: GitsDataSource) : GitsDataSource {

    var isRemote = false

    override fun remoteMovie(isRemote: Boolean) {
        this.isRemote = isRemote
    }

    override fun saveMovie(movie: Movie) {
        localDataSource.saveMovie(movie)
    }

    override fun getMovies(callback: GitsDataSource.GetMoviesCallback) {
        if (isRemote) {
            getRemoteMovieSource(callback)
        }
    }

    override fun getMovieById(movieId: Int, callback: GitsDataSource.GetMoviesByIdCallback) {
        localDataSource.getMovieById(movieId, object : GitsDataSource.GetMoviesByIdCallback{
            override fun onMovieLoaded(movie: Movie) {
                callback.onMovieLoaded(movie)
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        })
    }

    private fun getRemoteMovieSource(callback: GitsDataSource.GetMoviesCallback) {
        remoteDataSource.getMovies(object : GitsDataSource.GetMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                if (movies!!.isNotEmpty()) {
                    var j = 0

                    for (i in 0 until movies.size) {
                        j = i

                        localDataSource.saveMovie(Movie(movies[i].vote_count, movies[i].id, movies[i].isVideo,
                                movies[i].vote_average, movies[i].title, movies[i].popularity, movies[i].poster_path,
                                movies[i].original_language, movies[i].original_title, movies[i].backdrop_path,
                                movies[i].isAdult, movies[i].overview, movies[i].release_date))

                        if (j == movies.size - 1){
                            localDataSource.getMovies(object : GitsDataSource.GetMoviesCallback {
                                override fun onMoviesLoaded(movies: List<Movie>?) {
                                    callback.onMoviesLoaded(movies)
                                }

                                override fun onDataNotAvailable() {
                                    callback.onDataNotAvailable()
                                }

                                override fun onError(errorMessage: String?) {
                                    callback.onError(errorMessage)
                                }
                            })
                        }
                    }
                }
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

            override fun onError(errorMessage: String?) {
                callback.onError(errorMessage)
            }
        })
    }

    companion object {

        private var INSTANCE: GitsRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param gitsRemoteDataSourcethe backend data source
         * *
         * @return the [GitsRepository] instance
         */
        @JvmStatic
        fun getInstance(gitsRemoteDataSource: GitsDataSource, gitsLocalDataSource: GitsDataSource) =
                INSTANCE ?: synchronized(GitsRepository::class.java) {
                    INSTANCE ?: GitsRepository(gitsRemoteDataSource, gitsLocalDataSource)
                            .also { INSTANCE = it }
                }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}