package com.app.pokedex_45486_44499.Activities.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeRepository
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import kotlinx.coroutines.launch

private val TAG = "MainActivity"

class MainActivityViewModel(private val pokeRepository: PokeRepository): ViewModel(){

    val pokemonToRender: MutableLiveData<PokemonModel> = MutableLiveData()
    val pokeListResponse: MutableLiveData<PokemonListModel> = MutableLiveData()



    fun getPokemonListApiCall(){
       viewModelScope.launch {
           val response = pokeRepository.getPokemonList()
           pokeListResponse.value = response
           getPokemonFromList()
       }
    }

     fun getPokemonFromList(){
         viewModelScope.launch {
            for (pokemon in pokeListResponse.value?.results!!){
                val response = pokeRepository.getPokemon(pokemon.name)
                pokemonToRender.value = response
            }
         }
    }
}