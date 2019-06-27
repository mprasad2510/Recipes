package org.mp.recipes.data.di.feature.home.detail

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import org.mp.doctorsearchapp.utils.schedulers.BaseSchedulerProvider
import org.mp.recipes.data.Repository
import org.mp.recipes.data.di.mvibase.MviActionProcessorHolder
import javax.inject.Inject

class UserActionProcessorHolder @Inject constructor(private val repository: Repository,
                                                    private val schedulerProvider: BaseSchedulerProvider
) : MviActionProcessorHolder<UserAction, UserResult> {
    override fun transformFromAction(): ObservableTransformer<UserAction, UserResult> {
        return ObservableTransformer { action ->
            action.publish { shared ->
                Observable.merge(
                        shared.ofType(UserAction.LoadUserAction::class.java).compose(loadUser()),
                        shared.ofType(UserAction.ClickAction::class.java).compose(shareArticle()),
                        shared.ofType(UserAction.LoadTagsAction::class.java).compose(loadTags()),
                        shared.ofType(UserAction.LoadImageAction::class.java).compose(loadImage())
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

     fun loadImage(): ObservableTransformer<UserAction.LoadImageAction,UserResult.LoadImageResult> {
         return ObservableTransformer {
             action -> action.flatMap {
             repository.loadImage("61XHcqOBFYAYCGsKugoMYK")
                 .toObservable()
                 .map { response -> UserResult.LoadImageResult.Success(response.fields)
                 }
                 .cast(UserResult.LoadImageResult::class.java)
                 .onErrorReturn { t ->
                     UserResult.LoadImageResult.Failure(t.localizedMessage)
                 }
                 .subscribeOn(schedulerProvider.io())
                 .observeOn(schedulerProvider.ui())
                 .startWith(UserResult.LoadImageResult.InFlight)
         }
         }
     }
    fun loadTags(): ObservableTransformer<UserAction.LoadTagsAction,UserResult.LoadTagsResult> {

        return ObservableTransformer {
                action -> action.flatMap {
            repository.loadTags("3RvdyqS8408uQQkkeyi26k")
                .toObservable()
                .map { response -> UserResult.LoadTagsResult.Success(response.fields)
                }
                .cast(UserResult.LoadTagsResult::class.java)
                .onErrorReturn { t ->
                    UserResult.LoadTagsResult.Failure(t.localizedMessage)
                }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .startWith(UserResult.LoadTagsResult.InFlight)
        }
        }
    }
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