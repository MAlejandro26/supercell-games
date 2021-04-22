package uca.masr.supercell_games.di

import uca.masr.supercell_games.retrofit.GameRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RetrofitModule {
    @Singleton
    @Provides
    fun providesGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api-games-mobil.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideGameService(retrofit: Retrofit.Builder): GameRetrofit{
        return retrofit.build().create(GameRetrofit::class.java)
    }
}