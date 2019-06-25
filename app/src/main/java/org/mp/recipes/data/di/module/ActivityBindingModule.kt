package org.mp.recipes.data.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.mp.recipes.data.di.feature.home.HomeActivity
import org.mp.recipes.data.di.feature.home.detail.UserActivity


@Module
abstract class ActivityBindingModule  {

    @ContributesAndroidInjector(modules = [(MviModule::class)])
    abstract fun homeActivity(): HomeActivity
    @ContributesAndroidInjector(modules = [(MviModule::class)])
    abstract fun userActivity(): UserActivity
}