package org.mp.recipes.data.di.feature.home

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import org.mp.doctorsearchapp.utils.schedulers.BaseSchedulerProvider
import org.mp.recipes.data.Repository
import org.mp.recipes.data.di.mvibase.MviActionProcessorHolder

import javax.inject.Inject

class HomeActionProcessorHolder @Inject constructor(private val repository: Repository,
                                                    private val schedulerProvider: BaseSchedulerProvider
)
                                                  : MviActionProcessorHolder<HomeAction, HomeResult> {
    override fun transformFromAction(): ObservableTransformer<HomeAction, HomeResult> {
        return ObservableTransformer { action ->
            action.publish { shared ->
                Observable.merge(
                        shared.ofType(HomeAction.LoadHomeAction::class.java).compose(loadHome()),
                        shared.ofType(HomeAction.ClickAction::class.java).compose(shareArticle())

                )
            }
        }
    }


    private fun shareArticle(): ObservableTransformer<HomeAction.ClickAction, HomeResult.ClickResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                Observable.just(HomeResult.ClickResult(it.article))
            }
        }

    }

    private fun loadHome(): ObservableTransformer<HomeAction.LoadHomeAction, HomeResult.LoadHomeResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                repository.loadList()
                        .map { response -> HomeResult.LoadHomeResult.Success(response.items)
                         Log.d("***RESPONSE***","$response")}
                        .cast(HomeResult.LoadHomeResult::class.java)
                        .onErrorReturn { t ->
                            HomeResult.LoadHomeResult.Failure(t.localizedMessage)
                        }
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .startWith(HomeResult.LoadHomeResult.InFlight)
            }
        }

    }


}