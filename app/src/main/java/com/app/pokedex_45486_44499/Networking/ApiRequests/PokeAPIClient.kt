package com.app.pokedex_45486_44499.Networking.ApiRequests

import android.util.Log
import com.app.pokedex_45486_44499.Networking.BASE_URL
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "PokeAPIClient"

object PokeAPIClient {
    private val pokeAPIClient: PokeAPIRequests by lazy {
        setup()
    }

    private fun setup(): PokeAPIRequests {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory
                    .create()
            )
            .build().create()
    }

    fun getListOfPokemon(listener: PokeDataRetriever) {
        pokeAPIClient.getPokemonList().enqueue(object : Callback<PokemonListModel> {
            override fun onResponse(
                call: Call<PokemonListModel>,
                response: Response<PokemonListModel>
            ) {
                Log.d(TAG, "onResponse ${response.body()}")
                if (response.isSuccessful) {
                    listener.onListDataFetchSucess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PokemonListModel>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
                listener.onListDataFetchFailed()
            }
        })
    }


    private val pokemon: PokeAPIRequests by lazy {
        setupPokemon()
    }

    private fun setupPokemon(): PokeAPIRequests {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory
                    .create()
            )
            .build().create()
    }

    fun getPokemon(listener: PokeDataRetriever, pokemonName: String) {
        pokemon.getPokemon(pokemonName).enqueue(object : Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                if (response.isSuccessful) {
                    listener.onPokemonDataFetchSucess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
                listener.onListDataFetchFailed()
            }
        })
    }
}