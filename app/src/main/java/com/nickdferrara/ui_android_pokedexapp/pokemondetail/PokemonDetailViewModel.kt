package com.nickdferrara.ui_android_pokedexapp.pokemondetail

import androidx.lifecycle.ViewModel
import com.nickdferrara.ui_android_pokedexapp.data.remote.responses.Pokemon
import com.nickdferrara.ui_android_pokedexapp.repository.PokemonRepository
import com.nickdferrara.ui_android_pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel  @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}