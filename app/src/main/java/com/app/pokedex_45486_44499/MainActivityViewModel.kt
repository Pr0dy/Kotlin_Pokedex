package com.app.pokedex_45486_44499

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeDataRetriever
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonListModel.Result
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

private val TAG = "MainActivity"

class MainActivityViewModel: ViewModel(), PokeDataRetriever {

    private var allPokemonList = MutableLiveData<PokemonListModel>()
    var pokemonToRenderList = MutableLiveData<List<PokemonModel>>()

    fun getPokemonListApiCall(){
        PokeAPIClient.getListOfPokemon(this)
    }

    override fun onListDataFetchSucess(pokemonList: PokemonListModel) {
        Log.d(TAG, "Sucessful pokemon list request!")
        this.allPokemonList = pokemonList
    }

    override fun onListDataFetchFailed() {
        Log.d(TAG, "Unsucessful pokemon list request :( ")
    }

    override fun onPokemonDataFetchSucess(pokemon: PokemonModel) {
        Log.d(TAG, "Sucessful pokemon request!")
    }

    override fun onPokemonDataFetchFailed() {
        Log.d(TAG, "Unsucessful pokemon request :( ")
    }


}