package com.app.pokedex_45486_44499.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Activities.ViewModels.MainActivityViewModel
import com.app.pokedex_45486_44499.Activities.ViewModels.MainActivityViewModelFactory
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeRepository
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.R

class MainActivity : AppCompatActivity() {

     private lateinit var viewModel : MainActivityViewModel
     var pokemonList: MutableList<PokemonModel> = mutableListOf()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo = PokeRepository()
        val vmFactory = MainActivityViewModelFactory(repo)

        viewModel = ViewModelProvider(this,vmFactory).get(MainActivityViewModel::class.java)
        viewModel.getPokemonListApiCall()


         viewModel.pokemonToRender.observe(this) {
                Log.d("Response", pokemonList.size.toString())
                pokemonList.add(it)
                initializeRecyclerView(pokemonList)
         }
    }

    fun initializeRecyclerView(mutableList: MutableList<PokemonModel>) {
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        pokemonListRecycler.adapter = PokemonAdapter(mutableList)
    }
   }
