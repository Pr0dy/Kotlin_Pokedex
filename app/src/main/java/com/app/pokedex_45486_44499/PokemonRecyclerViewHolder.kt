package com.app.pokedex_45486_44499

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonRecyclerViewHolder(inflate: View): RecyclerView.ViewHolder(inflate) {

     val pokemonName = inflate.findViewById<TextView>(R.id.pokemonName)
     val pokemonNumber = inflate.findViewById<TextView>(R.id.pokemonNumber)
     //val pokemonImage = inflate.findViewById<TextView>(R.id.pokemonSpriteImage)

     fun render(pokemon: PokemonModel){
            pokemonName.text = pokemon.pokemonName
            pokemonNumber.text = pokemon.pokemonNumber.toString()
      }
}