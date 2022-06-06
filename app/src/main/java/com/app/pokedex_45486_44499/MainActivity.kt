package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeDataRetriever
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), PokeDataRetriever {

    var fetchedPokemonList: MutableList<PokemonModel>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PokeAPIClient.getListOfPokemon(this)
        //initializeRecyclerView()
    }

    fun initializeRecyclerView(){
        //val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        //pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        //pokemonListRecycler.adapter = PokemonAdapter(requestedPokemonList)
    }

    override fun onListDataFetchSucess(pokemonList: PokemonListModel) {
        Log.d(TAG, "Data Fetch Sucess!")
        var count = 0

        for (pokemon in pokemonList.results){
            PokeAPIClient.getPokemon(this,pokemon.name)
            if (count == 2){
                break
            }
            count++
        }
    }

    override fun onListDataFetchFailed() {
        Log.d(TAG, "Data Fetch Unsucessfull!")
    }

    override fun onPokemonDataFetchSucess(pokemon: PokemonModel) {
        Log.d(TAG, "Pokemon data fetch sucessful! ${pokemon}")
        fetchedPokemonList?.add(pokemon)
    }

    override fun onPokemonDataFetchFailed() {
        Log.d(TAG, "Pokemon data Fetch unsucessfull!")
    }
}