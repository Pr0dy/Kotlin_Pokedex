package com.app.pokedex_45486_44499.Networking.ApiRequests

import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPIRequests{
    @GET("pokemon?limit=150&offset=0")
    suspend fun getPokemonList(): PokemonListModel

    @GET("pokemon/{name}")
    suspend fun getSingularPokemon( @Path("name") name: String): PokemonModel
}