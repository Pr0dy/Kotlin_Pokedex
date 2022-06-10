package com.app.pokedex_45486_44499.Activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
     var favoriteList: MutableList<PokemonModel> = mutableListOf()

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repo = PokeRepository()
        val vmFactory = MainActivityViewModelFactory(repo)
         val alert = AlertDialog.Builder(this).create()
        alert.setTitle("Loading Pokemon from API")
        alert.setMessage("Please wait...")
        alert.show()

        viewModel = ViewModelProvider(this,vmFactory).get(MainActivityViewModel::class.java)
        viewModel.getPokemonListApiCall()


         viewModel.pokemonToRender.observe(this) {
                Log.d("Response", pokemonList.size.toString())
                pokemonList.add(it)

             if (pokemonList.size == 150){
                 initializeRecyclerView(pokemonList)
                 alert.dismiss()
             }
         }




    }

    fun initializeRecyclerView(mutableList: MutableList<PokemonModel>) {
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        pokemonListRecycler.adapter = PokemonAdapter(mutableList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.GenerationSelection -> {
                // Action goes here
                true
            }
            R.id.LogoutButton -> {
                // Action goes here
                true
            }
            R.id.FavoriteButton -> {
                // Action goes here
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
