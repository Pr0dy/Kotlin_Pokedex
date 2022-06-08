package com.app.pokedex_45486_44499

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeDataRetriever
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonListModel.Result
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

private val TAG = "MainActivity"

class MainActivityViewModel: ViewModel(), PokeDataRetriever {

    lateinit var allPokemon: PokemonListModel
    private val pokemonToRenderList = MutableLiveData<MutableList<PokemonModel>>()
    val pokemonList = pokemonToRenderList

    init {
        pokemonToRenderList.value = mutableListOf()
    }

    fun getPokemonListApiCall(){
        PokeAPIClient.getListOfPokemon(this)
    }

    override fun onListDataFetchSucess(pokemonList: PokemonListModel) {
        Log.d(TAG, "Sucessful pokemon list request!")
        allPokemon = pokemonList
        var count = 0

        for (pokemon in pokemonList.results){
            if (count < 5){
                PokeAPIClient.getPokemon(this,pokemon.name)
            }
            count+=1
        }
    }

    override fun onListDataFetchFailed() {
        Log.d(TAG, "Unsucessful pokemon list request :( ")
    }

    override fun onPokemonDataFetchSucess(pokemon: PokemonModel) {
        Log.d(TAG, "Sucessful pokemon request! ${pokemon.name}")
        pokemonToRenderList.value?.add(pokemon)
    }

    override fun onPokemonDataFetchFailed() {
        Log.d(TAG, "Unsucessful pokemon request :( ")
    }


}