package uca.masr.supercell_games.di

import android.app.Application
import uca.masr.supercell_games.utils.AdapterGame
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterGame{
        return AdapterGame()
    }
}