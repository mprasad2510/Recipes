package org.mp.recipes.data.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.mp.recipes.data.di.feature.home.HomeActivity


@Module
abstract class ActivityBindingModule  {

    @ContributesAndroidInjector(modules = [(MviModule::class)])
    abstract fun homeActivity(): HomeActivity

}