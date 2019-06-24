package org.mp.recipes.data.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.mp.recipes.MviApp
import org.mp.recipes.data.di.module.ActivityBindingModule
import org.mp.recipes.data.di.module.AppModule
import org.mp.recipes.data.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    NetworkModule::class,
    AppModule::class])

interface AppComponent : AndroidInjector<MviApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MviApp>(){

       // fun activityComponent(): ActivityComponent

        abstract fun appModule(appModule: AppModule) : Builder

        override fun seedInstance(instance: MviApp?) {
            appModule(AppModule(instance!!))
        }

    }
}