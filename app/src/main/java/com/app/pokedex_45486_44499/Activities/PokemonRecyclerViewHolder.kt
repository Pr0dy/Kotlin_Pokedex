package com.app.pokedex_45486_44499.Activities

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.R
import com.bumptech.glide.Glide

class PokemonRecyclerViewHolder(pokemonCellView: View): RecyclerView.ViewHolder(pokemonCellView) {

     val pokemonName = pokemonCellView.findViewById<TextView>(R.id.pokemonName)
     val pokemonNumber = pokemonCellView.findViewById<TextView>(R.id.pokemonNumber)
     val pokemonImage = pokemonCellView.findViewById<ImageView>(R.id.pokemonSpriteImage)

     fun render(pokemon: PokemonModel){
            pokemonName.text = pokemon.name.capitalize()
            pokemonNumber.text = "#${pokemon.id}"
            Glide.with(pokemonImage.context).load(pokemon.sprites.front_default).into(pokemonImage)
     }
}