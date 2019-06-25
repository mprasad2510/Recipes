package org.mp.recipes.data.di.module


import dagger.Module
import dagger.Provides
import org.mp.recipes.data.di.feature.home.HomeActionProcessorHolder
import org.mp.recipes.data.di.feature.home.HomeViewmodelFactory
import org.mp.recipes.data.di.feature.home.detail.UserActionProcessorHolder
import org.mp.recipes.data.di.feature.home.detail.UserViewModelFactory
import org.mp.recipes.data.di.scope.ActivityScope


@Module(includes = [DataModule::class])
class MviModule {
    @Provides
    @ActivityScope
    fun provideHomeViewmodelFactory(actionProcessorHolder: HomeActionProcessorHolder): HomeViewmodelFactory {
        return HomeViewmodelFactory(actionProcessorHolder)
    }
    @Provides
    @ActivityScope
    fun provideUserViewmodelFactory(actionProcessorHolder: UserActionProcessorHolder): UserViewModelFactory {
        return UserViewModelFactory(actionProcessorHolder)
    }
}