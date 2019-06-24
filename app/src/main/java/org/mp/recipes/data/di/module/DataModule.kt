package org.mp.recipes.data.di.module


import dagger.Module
import dagger.Provides
import org.mp.recipes.data.Repository
import org.mp.recipes.data.RepositoryImpl
import org.mp.recipes.data.remote.Network


@Module
class DataModule {
    @Provides
    fun provideRepository(network: Network): Repository {
        return RepositoryImpl(network)
    }
}