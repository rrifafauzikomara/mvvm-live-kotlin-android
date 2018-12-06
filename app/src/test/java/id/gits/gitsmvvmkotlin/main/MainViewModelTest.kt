package id.gits.gitsmvvmkotlin.main

import android.app.Application
import android.content.Context
import android.content.res.Resources
import id.gits.gitsmvvmkotlin.capture
import id.gits.gitsmvvmkotlin.data.model.Movie
import id.gits.gitsmvvmkotlin.data.source.GitsDataSource
import id.gits.gitsmvvmkotlin.data.source.GitsRepository
import id.gits.gitsmvvmkotlin.mvvm.main.MainViewModel
import junit.framework.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.verify

class MainViewModelTest {

    @Mock
    private lateinit var gitsRepository: GitsRepository

    @Mock
    private lateinit var context: Application

    @Captor
    private lateinit var loadMovieCallbackCaptor: ArgumentCaptor<GitsDataSource.GetMoviesCallback>

    private lateinit var mainViewModel: MainViewModel

    private var movies: MutableList<Movie> = mutableListOf<Movie>()

    @Before
    fun setupViewModel() {
        MockitoAnnotations.initMocks(this)

        setupContext()

        mainViewModel = MainViewModel(context, gitsRepository)

        movies.add(Movie(vote_count = 1))
    }

    @Test
    fun gitsRepository_movieLoaded() {
        with(mainViewModel) {
            // Init VM and movies data
            start()

            // Callback is captured and invoked with stubbed movies
            verify<GitsRepository>(gitsRepository).getMovies(capture(loadMovieCallbackCaptor))
            loadMovieCallbackCaptor.value.onMoviesLoaded(movies)

            // And movies loaded
            assertFalse(movies.isEmpty())
        }
    }

    private fun setupContext() {
        Mockito.`when`<Context>(context.applicationContext).thenReturn(context)
        Mockito.`when`(context.resources).thenReturn(Mockito.mock(Resources::class.java))
    }
}