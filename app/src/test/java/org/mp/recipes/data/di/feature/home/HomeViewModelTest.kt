package org.mp.recipes.data.di.feature.home

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mp.doctorsearchapp.utils.schedulers.BaseSchedulerProvider
import org.mp.doctorsearchapp.utils.schedulers.ImmediateSchedulerProvider
import org.mp.recipes.data.Repository
import org.mp.recipes.data.remote.model.*


class HomeViewModelTest {
    @Mock
    private lateinit var repository: Repository
    private lateinit var schedulerProvider: BaseSchedulerProvider
    private lateinit var homeViewModel: HomeViewModel
    @Mock
    lateinit var observer: Observer<HomeViewState>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUpLoginViewModel() {
        MockitoAnnotations.initMocks(this)
        schedulerProvider = ImmediateSchedulerProvider()
        homeViewModel = HomeViewModel(HomeActionProcessorHolder(repository, schedulerProvider))
        homeViewModel.states().observeForever(observer)
    }

    @Test
    fun InitialIntentTest() {
        val includes = Includes(emptyList())
        val sys : Sys? = null
        val list = Response(0,0,0,includes,sys, emptyList())
        whenever(repository.loadList()).thenReturn(
            Single.just(list))
        homeViewModel.processIntents(Observable.just(HomeIntent.InitialIntent))

        verify(observer).onChanged(HomeViewState(
                isLoading = false,
                isError = false,
                errorMessage = 0,
                articles = emptyList(),
                showShareOption = false,
                shareArticle = null
        ))
    }

    @Test
    fun LoadErrorTest() {
        whenever(repository.loadList()).thenReturn(Single.error(Throwable("This is somekind of error")))
        homeViewModel.processIntents(Observable.just(HomeIntent.InitialIntent))
        verify(observer).onChanged(HomeViewState(
                isLoading = false,
                isError = false,
                errorMessage = 0,
                articles = emptyList(),
                shareArticle = null,
                showShareOption = false))
    }

    @Test
    fun onClickTest() {
        val article = mock<Response> {  }
        homeViewModel.processIntents(Observable.just(HomeIntent.ClickIntent(article.items[0].fields)))
        verify(observer).onChanged(HomeViewState(
                isLoading = false,
                isError = false,
                errorMessage = 0,
                articles = emptyList(),
                shareArticle = mock<Fields>{  },
                showShareOption = true
        ))
    }

}