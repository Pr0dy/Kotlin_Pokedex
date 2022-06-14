package com.app.pokedex_45486_44499.RoomImplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import java.util.concurrent.Executors


@Database(entities = [PokemonModel::class], version = 1, exportSchema = false)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun  pokemonDao(): PokemonDAO

    companion object{
       @Volatile
       private var INSTANCE: PokemonDatabase? = null

       fun getDatabase(context: Context): PokemonDatabase {
           return INSTANCE ?: synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext, PokemonDatabase::class.java, "pokemon_database"
               ).build()

               INSTANCE = instance
               instance
           }
       }val databaseWriteExecutor = Executors.newFixedThreadPool(2)
    }

}