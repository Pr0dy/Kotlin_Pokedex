package com.app.pokedex_45486_44499.Networking

import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

interface PokeDataRetriever {
    fun onListDataFetchSucess(pokemonList: PokemonListModel)
    fun onListDataFetchFailed()
    fun onPokemonDataFetchSucess(pokemon: PokemonModel)
    fun onPokemonDataFetchFailed()
}