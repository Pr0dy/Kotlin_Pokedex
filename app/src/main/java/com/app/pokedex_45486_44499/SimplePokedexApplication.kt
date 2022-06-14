package com.app.pokedex_45486_44499

import android.app.Application
import com.app.pokedex_45486_44499.RoomImplementation.PokeRepository
import com.app.pokedex_45486_44499.RoomImplementation.PokemonDatabase

class SimplePokedexApplication: Application() {
    val database by lazy { PokemonDatabase.getDatabase(this) }
    val repository by lazy { PokeRepository(database.pokemonDao()) }
}