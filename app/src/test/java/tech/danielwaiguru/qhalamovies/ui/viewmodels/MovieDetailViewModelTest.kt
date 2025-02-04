package tech.danielwaiguru.qhalamovies.ui.viewmodels

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import tech.danielwaiguru.domain.repository.MovieRepository
import tech.danielwaiguru.domain.use_cases.GetMovieDetailsUseCase
import tech.danielwaiguru.qhalamovies.base.BaseViewModelTest

class MovieDetailViewModelTest: BaseViewModelTest() {
    private lateinit var detailViewModel: MovieDetailViewModel
    private val detailsUseCase: GetMovieDetailsUseCase = mock()

    @Before
    fun setup() {
        detailViewModel = MovieDetailViewModel(detailsUseCase)
    }
    @Test
    fun `call to fetch particular movie details`() = runBlockingTest {
        detailViewModel.fetchMovieDetails(1)
        verify(detailsUseCase).invoke(1)
    }
}