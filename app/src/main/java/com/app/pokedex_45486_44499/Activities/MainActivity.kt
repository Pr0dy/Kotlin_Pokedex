package com.app.pokedex_45486_44499.Activities
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.ViewModels.MainActivityViewModel
import com.app.pokedex_45486_44499.ViewModels.MainActivityViewModelFactory
import com.app.pokedex_45486_44499.Room.PokeRepository
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.R
import com.app.pokedex_45486_44499.SimplePokedexApplication

class MainActivity : AppCompatActivity() {

     private val viewModel : MainActivityViewModel by viewModels{
         MainActivityViewModelFactory((application as SimplePokedexApplication).repository)
     }

     var pokemonList: MutableList<PokemonModel> = mutableListOf()
     var favoriteList: MutableList<PokemonModel> = mutableListOf()
     var favoriteListShowing = false
     var update = true

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alert = AlertDialog.Builder(this).create()
        alert.setTitle("Loading Pokemon from API")
        alert.setMessage("Please wait...")
        alert.show()


         viewModel.getPokemonFromDB().observe(this) {

             if(it.isEmpty()){
                 viewModel.getPokemonListApiCall()
             }

             if (it.size == 150 && update){
                 update = false
                 pokemonList = it as MutableList<PokemonModel>
                 initializeRecyclerView(it as MutableList<PokemonModel>,(application as SimplePokedexApplication).repository)
                 alert.dismiss()
             }
         }
    }

    fun initializeRecyclerView(mutableList: MutableList<PokemonModel>, repository: PokeRepository) {
        val pokemonListRecycler = findViewById<RecyclerView>(R.id.PokemonRecyclerView)
        pokemonListRecycler.layoutManager = LinearLayoutManager(this)
        pokemonListRecycler.adapter = PokemonAdapter(mutableList,repository)
    }

    fun renderFavoritePokemonList(pokemonList: MutableList<PokemonModel>){
        for (pokemon in pokemonList){
            if (pokemon.isFavorite!!){
                favoriteList.add(pokemon)
            }
        }
        initializeRecyclerView(favoriteList, (application as SimplePokedexApplication).repository)
        favoriteListShowing = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.LogoutButton -> {
                finish()
                true
            }
            R.id.FavoriteButton -> {
                if(!favoriteListShowing){
                    renderFavoritePokemonList(pokemonList)
                } else {
                    initializeRecyclerView(
                        pokemonList,
                        (application as SimplePokedexApplication).repository
                    )
                    favoriteList.clear()
                    favoriteListShowing = false
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
