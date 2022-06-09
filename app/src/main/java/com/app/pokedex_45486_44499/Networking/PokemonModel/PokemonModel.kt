package com.app.pokedex_45486_44499.Networking.PokemonModel

data class PokemonModel(
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val name: String,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int,
    var isFavorite: Boolean = false
)