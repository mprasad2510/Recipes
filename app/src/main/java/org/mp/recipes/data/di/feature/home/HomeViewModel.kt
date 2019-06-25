package org.mp.recipes.data.di.feature.home


import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import org.mp.recipes.data.di.base.BaseViewModel
import org.mp.recipes.data.di.mvibase.MviActionProcessorHolder


class HomeViewModel(private val homeActionProcessorHolder:
                    HomeActionProcessorHolder
) :
        BaseViewModel<HomeIntent, HomeViewState, HomeAction, HomeResult>() {

    override fun initialState(): HomeViewState = HomeViewState.idle()
    override fun reducer(): BiFunction<HomeViewState, HomeResult, HomeViewState> = reducer
    override fun actionProcessorHolder(): MviActionProcessorHolder<HomeAction, HomeResult> =homeActionProcessorHolder
    override fun intentFilter(): ObservableTransformer<HomeIntent, HomeIntent> {
        return ObservableTransformer { intents ->
            intents.publish { shared ->
                Observable.merge<HomeIntent>(
                        shared.ofType(HomeIntent.InitialIntent::class.java).take(2),
                        shared.filter { it != HomeIntent.InitialIntent }
                )
            }
        }


    }

    init {
        connectObservableToLiveData()
    }

    override fun actionFromIntent(intent: HomeIntent): HomeAction {
        return when (intent) {
            is HomeIntent.InitialIntent -> HomeAction.LoadHomeAction
            is HomeIntent.ClickIntent -> HomeAction.ClickAction(intent.article)
        }
    }

    companion object {
        private val reducer = BiFunction { previousState: HomeViewState, result: HomeResult ->
            when (result) {
                is HomeResult.LoadHomeResult -> {
                    when (result) {
                        is HomeResult.LoadHomeResult.Success -> {
                            previousState.copy(isLoading = false, isError = false, errorMessage = 401, articles = result.newsList)
                        }
                        is HomeResult.LoadHomeResult.Failure -> {
                            previousState.copy(isLoading = false, isError = true, errorMessage = 401)
                        }
                        is HomeResult.LoadHomeResult.InFlight -> {
                            previousState.copy(isLoading = true, isError = false, errorMessage = 401, showShareOption = false)
                        }
                    }
                }

                is HomeResult.ClickResult -> {
                    //TODO: if user clicks twice in the same item share intent will not show for 2nd time coz distinctUntilChanged()
                    //TODO: Figure out a way to avoid this.
                    previousState.copy(showShareOption = true, shareArticle = result.article)
                }
            }
        }
    }

}