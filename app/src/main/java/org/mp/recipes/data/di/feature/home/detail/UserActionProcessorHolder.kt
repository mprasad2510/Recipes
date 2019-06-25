package org.mp.recipes.data.di.feature.home.detail




import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single
import org.mp.doctorsearchapp.utils.schedulers.BaseSchedulerProvider
import org.mp.recipes.data.Repository
import org.mp.recipes.data.di.feature.home.HomeActivity
import org.mp.recipes.data.di.feature.home.HomeActivity.Companion.id
import org.mp.recipes.data.di.mvibase.MviActionProcessorHolder
import org.mp.recipes.data.remote.model.FieldsUrl
import org.mp.recipes.data.remote.model.LoadImageResponse
import javax.inject.Inject

class UserActionProcessorHolder @Inject constructor(private val repository: Repository,
                                                    private val schedulerProvider: BaseSchedulerProvider
) : MviActionProcessorHolder<UserAction, UserResult> {
    override fun transformFromAction(): ObservableTransformer<UserAction, UserResult> {
        return ObservableTransformer { action ->
            action.publish { shared ->
                Observable.merge(
                        shared.ofType(UserAction.LoadUserAction::class.java).compose(loadUser()),
                        shared.ofType(UserAction.ClickAction::class.java).compose(shareArticle())
                    )
            }
        }
    }


    private fun shareArticle(): ObservableTransformer<UserAction.ClickAction, UserResult.ClickResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                Observable.just(UserResult.ClickResult(it.user))
            }
        }

    }

//     fun loadImage(): Observable<FieldsUrl> {
//        return repository.loadImage(assetId)
//                    .toObservable()
//                    .map { response -> response.fields}
//    }
     var assetId = ""
     private fun loadUser(): ObservableTransformer<UserAction.LoadUserAction, UserResult.LoadUserResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                repository.loadDetailList(UserActivity.id)
                    .toObservable()
                        .map { response -> UserResult.LoadUserResult.Success(response.fields)
                          //  assetId = response.sys.id
                        }
                        .cast(UserResult.LoadUserResult::class.java)
                        .onErrorReturn { t ->
                            UserResult.LoadUserResult.Failure(t.localizedMessage)
                        }
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .startWith(UserResult.LoadUserResult.InFlight)

            }
        }

    }
}