package com.app.pokedex_45486_44499.Activities

import androidx.room.TypeConverter
import com.app.pokedex_45486_44499.Networking.PokemonModel.Sprites
import com.app.pokedex_45486_44499.Networking.PokemonModel.Type
import com.app.pokedex_45486_44499.Networking.PokemonModel.TypeX
import com.google.gson.Gson

class Converters {
     @TypeConverter
        fun fromSprite(value: Sprites): String {
            return value.front_default
        }

       @TypeConverter
        fun toSprite(value: String): Sprites {
           return Sprites(value)
        }

    @TypeConverter
    fun fromType(value: List<Type>): String {
        return value[0].type.name
    }

    @TypeConverter
    fun toSType(value: String): List<Type> {
        return listOf(Type((TypeX(value))))
    }
}