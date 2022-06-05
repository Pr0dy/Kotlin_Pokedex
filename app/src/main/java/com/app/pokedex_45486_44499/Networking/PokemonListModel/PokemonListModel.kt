package com.app.pokedex_45486_44499.Networking.PokemonListModel

data class PokemonListModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)