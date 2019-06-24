package org.mp.recipes.data.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.mp.doctorsearchapp.utils.schedulers.BaseSchedulerProvider
import org.mp.doctorsearchapp.utils.schedulers.SchedulerProvider
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideSchedular(): BaseSchedulerProvider = SchedulerProvider()
}