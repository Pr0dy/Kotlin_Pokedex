package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

 class MainActivity : AppCompatActivity() {
     private val viewModel : MainActivityViewModel by viewModels()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getPokemonListApiCall()

            viewModel.pokemonList.observe(this){
                if (it.size > 0) {
                    print("gay")
                }
    }

    fun initializeRecyclerView(mutableList: MutableList<PokemonModel>) {
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        pokemonListRecycler.adapter = PokemonAdapter(mutableList)
    }
   }
 }