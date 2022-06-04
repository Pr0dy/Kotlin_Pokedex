package com.app.pokedex_45486_44499

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonRecyclerViewHolder(pokemonCellView: View): RecyclerView.ViewHolder(pokemonCellView) {

     val pokemonName = pokemonCellView.findViewById<TextView>(R.id.pokemonName)
     val pokemonNumber = pokemonCellView.findViewById<TextView>(R.id.pokemonNumber)
     val pokemonImage = pokemonCellView.findViewById<ImageView>(R.id.pokemonSpriteImage)

     fun render(pokemon: PokemonModel){
            pokemonName.text = pokemon.pokemonName
            pokemonNumber.text = pokemon.pokemonNumber.toString()
            Glide.with(pokemonImage.context).load(pokemon.pokemonImageURL).into(pokemonImage)
      }
}