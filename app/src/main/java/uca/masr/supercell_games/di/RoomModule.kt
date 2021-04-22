package uca.masr.supercell_games.di

import android.content.Context
import androidx.room.Room
import uca.masr.supercell_games.room.GameDao
import uca.masr.supercell_games.room.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideGameDb(@ApplicationContext context: Context): GameDatabase{
        return Room.databaseBuilder(context, GameDatabase::class.java, GameDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideGameDao(gameDatabase: GameDatabase): GameDao{
        return gameDatabase.gameDao()
    }
}