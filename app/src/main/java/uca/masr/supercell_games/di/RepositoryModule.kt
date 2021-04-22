package uca.masr.supercell_games.di

import uca.masr.supercell_games.repository.GameRepository
import uca.masr.supercell_games.retrofit.NetworkMapper
import uca.masr.supercell_games.retrofit.GameRetrofit
import uca.masr.supercell_games.room.CacheMapper
import uca.masr.supercell_games.room.GameDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGameRepository(
        placeDao: GameDao,
        placeRetrofit: GameRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): GameRepository {
        return GameRepository(placeDao, placeRetrofit, cacheMapper, networkMapper)
    }
}