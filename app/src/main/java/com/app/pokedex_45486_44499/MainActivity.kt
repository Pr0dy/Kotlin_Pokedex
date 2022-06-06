package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeDataRetriever
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), PokeDataRetriever {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PokeAPIClient.getListOfPokemon(this)
        //initializeRecyclerView()
    }

    fun initializeRecyclerView(){
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)

        //pokemonListRecycler.adapter = PokemonAdapter(requestedPokemonList)
    }

    override fun onListDataFetchSucess(pokemonList: PokemonListModel) {
        Log.d(TAG, "Data Fetch Sucess!")
    }

    override fun onListDataFetchFailed() {
        Log.d(TAG, "Data Fetch Unsucessfull!")
    }

    override fun onPokemonDataFetchSucess(pokemon: List<PokemonModel>) {
        Log.d(TAG, "Data Fetch Sucess!")
    }

    override fun onPokemonDataFetchFailed() {
        Log.d(TAG, "Data Fetch Unsucessfull!")
    }
}