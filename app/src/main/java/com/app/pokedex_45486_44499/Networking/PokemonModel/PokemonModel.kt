package com.app.pokedex_45486_44499.Networking.PokemonModel

import com.squareup.moshi.Json

data class PokemonModel(
    @Json(name = "base_experience")
    val base_experience: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "held_items")
    val held_items: List<Any>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "is_default")
    val is_default: Boolean,
    @Json(name = "location_area_encounters")
    val location_area_encounters: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "order")
    val order: Int,
    @Json(name = "past_types")
    val past_types: List<Any>,
    @Json(name = "species")
    val species: Species,
    @Json(name = "sprites")
    val sprites: Sprites,
    @Json(name = "stats")
    val stats: List<Stat>,
    @Json(name = "types")
    val types: List<Type>,
    @Json(name = "weight")
    val weight: Int
)