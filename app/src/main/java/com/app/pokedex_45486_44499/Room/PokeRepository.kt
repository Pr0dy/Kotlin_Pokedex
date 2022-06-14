package com.app.pokedex_45486_44499.Room

import androidx.lifecycle.LiveData
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

class PokeRepository(private val pokemonDAO: PokemonDAO) {

    val allPokemonList: LiveData<List<PokemonModel>> = pokemonDAO.getPokemonFromDB()

    fun insert(pokemon: PokemonModel){
        PokemonDatabase.databaseWriteExecutor.execute{
            pokemonDAO.insertPokemon(pokemon)
        }
    }

    fun updateFavoritePokemonState(pokemon: PokemonModel){
        PokemonDatabase.databaseWriteExecutor.execute{
            pokemonDAO.updateFavorite(pokemon.id, pokemon.isFavorite)
        }
    }

    fun getPokemonForPaging(upperID: Int, lowerID: Int):List<PokemonModel> {

        var pokemonForPaging: List<PokemonModel>? = null

        PokemonDatabase.databaseWriteExecutor.execute{
             pokemonForPaging = pokemonDAO.getPokemonForPaging(upperID,lowerID)
        }
        return pokemonForPaging!!
    }

    suspend fun getPokemonList(): PokemonListModel {
        return PokeAPIClient.pokeAPI.getPokemonList()
    }

    suspend fun getPokemon(pokeName: String): PokemonModel{
        return PokeAPIClient.pokeAPI.getSingularPokemon(pokeName)
    }

}