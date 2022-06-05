package com.app.pokedex_45486_44499.Networking.ApiRequests

import android.util.Log
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.Networking.REQUEST_POKEMON_LIST_URL
import com.app.pokedex_45486_44499.Networking.REQUEST_SINGLE_POKEMON_URL
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "PokeAPIClient"

object PokeAPIClient {
    private val pokeAPIClient: PokeAPIRequests by lazy {
        setup()
    }

    private fun setup(): PokeAPIRequests{
        return Retrofit.Builder().baseUrl(REQUEST_POKEMON_LIST_URL)
            .addConverterFactory(MoshiConverterFactory
                .create())
            .build().create()
    }

    fun getListOfPokemon(listener: PokeDataRetriever){
        pokeAPIClient.getPokemonList().enqueue(object : Callback<List<PokemonListModel>>{
            override fun onResponse(call: Call<List<PokemonListModel>>, response: Response<List<PokemonListModel>>) {
                Log.d(TAG, "onResponse ${response.body()}")
                listener.onListDataFetchSucess(response.body()!!)
            }

            override fun onFailure(call: Call<List<PokemonListModel>>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
                listener.onListDataFetchFailed()
            }
        })
    }

    private val pokemon: PokeAPIRequests by lazy {
        setupPokemon()
    }

    private fun setupPokemon(): PokeAPIRequests{
        return Retrofit.Builder().baseUrl(REQUEST_SINGLE_POKEMON_URL)
            .addConverterFactory(MoshiConverterFactory
                .create())
            .build().create()
    }
/*
    fun getPokemon(){
        pokemon.getPokemon().enqueue(object : Callback<List<PokemonModel>>{
            override fun onResponse(call: Call<List<PokemonModel>>, response: Response<List<PokemonModel>>) {
                Log.d(TAG, "onResponse ${response.body()}")
            }

            override fun onFailure(call: Call<List<PokemonModel>>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
            }
        })
    */
}