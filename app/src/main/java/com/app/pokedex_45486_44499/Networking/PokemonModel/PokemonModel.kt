package com.app.pokedex_45486_44499.Networking.PokemonModel
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "PokemonTable")
data class PokemonModel(
    @PrimaryKey
    var id: Int,
    var name: String,
    var sprites: Sprites,
    var types: List<Type>,
    var isFavorite: Boolean,
    //var type: String = types[0].type.name
){ constructor(): this(id = -1, name = "", sprites = Sprites(""), types = emptyList(), isFavorite = false)}



