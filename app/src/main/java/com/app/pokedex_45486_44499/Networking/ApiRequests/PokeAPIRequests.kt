package com.app.pokedex_45486_44499.Networking.ApiRequests

import com.app.pokedex_45486_44499.Networking.BASE_URL
import com.app.pokedex_45486_44499.Networking.POKEMON_LIST
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import retrofit2.Call
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPIRequests{
    @GET(POKEMON_LIST)
    fun getPokemonList(): Call<PokemonListModel>

    @GET("pokemon/{name}")
    fun getSingularPokemon(name: String): Call<PokemonModel>
}