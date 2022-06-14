package com.app.pokedex_45486_44499.Networking.PokemonModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PokemonTable")
data class PokemonModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "sprites")
    val sprites: Sprites,
    @ColumnInfo(name = "types")
    val types: List<Type>,
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)