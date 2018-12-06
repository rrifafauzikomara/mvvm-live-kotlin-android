package id.gits.gitsmvvmkotlin.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

@Entity(tableName = "movies")
data class Movie(
        @ColumnInfo(name = "vote_count")
        var vote_count: Int? = null,

        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,

        @ColumnInfo(name = "isVideo")
        var isVideo: Boolean? = null,

        @ColumnInfo(name = "vote_average")
        var vote_average: Double? = null,

        @ColumnInfo(name = "title")
        var title: String? = null,

        @ColumnInfo(name = "popularity")
        var popularity: Double? = null,

        @ColumnInfo(name = "poster_path")
        var poster_path: String? = null,

        @ColumnInfo(name = "original_language")
        var original_language: String? = null,

        @ColumnInfo(name = "original_title")
        var original_title: String? = null,

        @ColumnInfo(name = "backdrop_path")
        var backdrop_path: String? = null,

        @ColumnInfo(name = "isAdult")
        var isAdult: Boolean? = null,

        @ColumnInfo(name = "overview")
        var overview: String? = null,

        @ColumnInfo(name = "release_date")
        var release_date: String? = null
): Serializable