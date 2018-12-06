package id.gits.gitsmvvmkotlin.util

import android.content.Context
import id.gits.gitsmvvmkotlin.data.source.GitsRepository
import id.gits.gitsmvvmkotlin.data.source.local.GitsAppDatabase
import id.gits.gitsmvvmkotlin.data.source.local.GitsLocalDataSource
import id.gits.gitsmvvmkotlin.data.source.remote.GitsRemoteDataSource
import id.gits.gitsmvvmkotlin.util.dbhelper.AppExecutors

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

object Injection {

    fun provideGitsRepository(context: Context): GitsRepository {
        val localDatabase = GitsAppDatabase.getInstance(context)

        return GitsRepository.getInstance(GitsRemoteDataSource,
                GitsLocalDataSource.getInstance(AppExecutors(), localDatabase.movieDao()))
    }
}