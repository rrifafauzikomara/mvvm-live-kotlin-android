package id.gits.gitsmvvmkotlin.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.data.source.local.movie.MovieDao

@Database(entities = [(Movie::class)], version = 2)
abstract class GitsAppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: GitsAppDatabase? = null

        fun getInstance(context: Context): GitsAppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also {
                        INSTANCE = it
                    }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        GitsAppDatabase::class.java, "Movies.db")
                        .build()
    }
}