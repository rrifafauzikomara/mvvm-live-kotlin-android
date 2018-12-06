package id.gits.gitsmvvmkotlin.data.source.remote

import id.gits.gitsmvvmkotlin.BuildConfig
import id.gits.gitsmvvmkotlin.base.BaseApiModel
import id.gits.gitsmvvmkotlin.data.model.Movie
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

interface GitsApiService {

    @GET("https://api.themoviedb.org/3/discover/movie?api_key=24d18ef569e3997bf2779d05440d3c6e&sort_by=popularity.desc")
    fun getMovies(): Observable<BaseApiModel<List<Movie>>>

    companion object Factory {

        fun create(): GitsApiService {
            val mLoggingInterceptor = HttpLoggingInterceptor()
            mLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val mClient = OkHttpClient.Builder()
                    .addInterceptor(mLoggingInterceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()

            val mRetrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mClient) //Todo comment if app release
                    .build()

            return mRetrofit.create(GitsApiService::class.java)
        }
    }
}