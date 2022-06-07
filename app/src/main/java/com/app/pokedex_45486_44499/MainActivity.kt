package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeAPIClient
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeDataRetriever
import com.app.pokedex_45486_44499.Networking.PokemonListModel.PokemonListModel
import com.app.pokedex_45486_44499.Networking.PokemonListModel.Result
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel

 class MainActivity : AppCompatActivity() {

     private val viewModel : MainActivityViewModel by viewModels()
     var pokemonList:  MutableLiveData<PokemonListModel>? = MutableLiveData()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun initializeRecyclerView(){
        //val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        //pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        //pokemonListRecycler.adapter = PokemonAdapter(requestedPokemonList)
    }
}