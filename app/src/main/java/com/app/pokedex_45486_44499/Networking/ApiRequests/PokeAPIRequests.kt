package com.app.pokedex_45486_44499.Networking.ApiRequests

import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import retrofit2.Call
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.Networking.REQUEST_POKEMON_LIST_URL
import com.app.pokedex_45486_44499.Networking.REQUEST_SINGLE_POKEMON_URL
import retrofit2.http.GET

interface PokeAPIRequests{
    @GET(REQUEST_POKEMON_LIST_URL)
    fun getPokemonList(): Call<List<PokemonListModel>>

    @GET(REQUEST_SINGLE_POKEMON_URL)
    fun getPokemon(): Call<PokemonModel>
}