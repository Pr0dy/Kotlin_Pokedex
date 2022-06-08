package com.app.pokedex_45486_44499.Networking.ApiRequests

import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import retrofit2.Call


class PokeRepository {

    suspend fun getPokemonList(): PokemonListModel {
        return PokeAPIClient.pokeAPI.getPokemonList()
    }

    suspend fun getPokemon(pokeName: String): PokemonModel{
        return PokeAPIClient.pokeAPI.getSingularPokemon(pokeName)
    }

}