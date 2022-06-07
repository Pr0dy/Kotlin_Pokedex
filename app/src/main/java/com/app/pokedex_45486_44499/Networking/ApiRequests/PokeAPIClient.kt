package com.app.pokedex_45486_44499.Networking.ApiRequests
import com.app.pokedex_45486_44499.Networking.BASE_URL
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

object PokeAPIClient {

    //petições á API que retorna data com lista de nomes de todos os Pokemons
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
                if (response.isSuccessful) {
                    listener.onListDataFetchSucess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PokemonListModel>, t: Throwable) {
                listener.onListDataFetchFailed()
            }
        })
    }

    //petições á API que retornam data referem-te a cada Pokemon individual
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
        pokemon.getSingularPokemon(pokemonName).enqueue(object : Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                if (response.isSuccessful) {
                    listener.onPokemonDataFetchSucess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                listener.onListDataFetchFailed()
            }
        })
    }
}