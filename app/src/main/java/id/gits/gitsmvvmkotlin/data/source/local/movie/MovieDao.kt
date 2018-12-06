package id.gits.gitsmvvmkotlin.data.source.local.movie

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import id.gits.gitsmvvmkotlin.data.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun getMovieById(id: Int): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

}