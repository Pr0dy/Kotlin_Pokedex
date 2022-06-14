package com.app.pokedex_45486_44499.RoomImplementation

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM PokemonTable")
    fun getPokemonFromDB(): LiveData<List<PokemonModel>>

    @Insert
    fun insertPokemon(pokemon: PokemonModel)

    @Query("UPDATE PokemonTable SET isFavorite = :set WHERE id = :pokemonID")
    fun updateFavorite(pokemonID: Int, set: Boolean)

    @Query("SELECT * FROM PokemonTable WHERE id < :upperID AND id >= :lowerID")
    fun getPokemonForPaging(upperID: Int, lowerID: Int): List<PokemonModel>
}