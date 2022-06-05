package com.app.pokedex_45486_44499.Networking.ApiRequests

import com.app.pokedex_45486_44499.Networking.REQUEST_POKEMON_LIST_URL
import com.app.pokedex_45486_44499.Networking.REQUEST_SINGLE_POKEMON_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

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

    fun getListOfPokemon(){
        pokeAPIClient.getPokemonList()
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

    fun getPokemon(){
        pokemon.getPokemon()
    }
}