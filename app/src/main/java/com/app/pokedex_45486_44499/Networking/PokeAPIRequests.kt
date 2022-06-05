package com.app.pokedex_45486_44499.Networking

import retrofit2.Call
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import retrofit2.http.GET

interface PokeAPIRequests{
    @GET(BASE_URL)
    fun getPokemonList(): Call<List<PokemonModel>>
}