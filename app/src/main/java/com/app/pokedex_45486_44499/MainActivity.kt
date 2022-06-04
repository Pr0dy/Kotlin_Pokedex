package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val pokemonList = listOf(
        PokemonModel("pokemon1",1,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
        PokemonModel("pokemon2",2,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
        PokemonModel("pokemon3",3,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"),
        PokemonModel("pokemon4",4,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
        PokemonModel("pokemon5",5,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png"),
        PokemonModel("pokemon5",6,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecyclerView()
    }

    fun initializeRecyclerView(){
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        pokemonListRecycler.adapter = PokemonAdapter(pokemonList)
    }
}