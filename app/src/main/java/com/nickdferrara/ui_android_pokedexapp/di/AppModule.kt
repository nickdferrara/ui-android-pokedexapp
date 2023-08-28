package com.nickdferrara.ui_android_pokedexapp.di

import com.nickdferrara.ui_android_pokedexapp.data.remote.PokeApi
import com.nickdferrara.ui_android_pokedexapp.repository.PokemonRepository
import com.nickdferrara.ui_android_pokedexapp.util.Contants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)

    fun providePokeApi(): PokeApi {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}