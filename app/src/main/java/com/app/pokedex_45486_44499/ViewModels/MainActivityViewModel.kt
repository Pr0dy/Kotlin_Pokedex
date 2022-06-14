package com.app.pokedex_45486_44499.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex_45486_44499.RoomImplementation.PokeRepository
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import kotlinx.coroutines.launch

class MainActivityViewModel(private val pokeRepository: PokeRepository): ViewModel(){

    val pokeListResponse: MutableLiveData<PokemonListModel> = MutableLiveData()

    fun getPokemonFromDB(): LiveData<List<PokemonModel>>{
        return pokeRepository.allPokemonList
    }

    fun addPokemon(pokemon: PokemonModel){
        pokeRepository.insert(pokemon)
    }

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
                print("i was here")
                addPokemon(response)
            }
         }
    }
}