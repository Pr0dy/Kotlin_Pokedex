package com.app.pokedex_45486_44499.Activities

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.bumptech.glide.Glide


class PokemonRecyclerViewHolder(pokemonCellView: View): RecyclerView.ViewHolder(pokemonCellView) {

     val pokemonName = pokemonCellView.findViewById<TextView>(com.app.pokedex_45486_44499.R.id.pokemonName)
     val pokemonNumber = pokemonCellView.findViewById<TextView>(com.app.pokedex_45486_44499.R.id.pokemonNumber)
     val pokemonImage = pokemonCellView.findViewById<ImageView>(com.app.pokedex_45486_44499.R.id.pokemonSpriteImage)
     val pokemonPrimaryTypeImage = pokemonCellView.findViewById<ImageView>(com.app.pokedex_45486_44499.R.id.pokemonPrimaryType)


     fun render(pokemon: PokemonModel){
            pokemonName.text = pokemon.name.capitalize()
            pokemonNumber.text = "#${pokemon.id}"
            Glide.with(pokemonImage.context).load(pokemon.sprites.front_default).into(pokemonImage)
            setTypeImage(pokemon.types[0].type.name)
     }

     fun setTypeImage(pokemonType: String) {
         when (pokemonType){
             "normal" -> pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_bug_type_icon) ;
             "fighting" ->   pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_fighting_type_icon)
             "flying" ->   pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_flying_type_icon)
             "poison" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_poison_type_icon)
             "ground" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_ground_type_icon)
             "rock" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_rock_type_icon)
             "bug" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_bug_type_icon)
             "ghost" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_ghost_type_icon)
             "steel" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_steel_type_icon)
             "fire" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_fire_type_icon)
             "water" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_water_type_icon)
             "grass" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_grass_type_icon)
             "electric" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_electric_type_icon)
             "psychic" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_psychic_type_icon)
             "ice" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_ice_type_icon)
             "dragon" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_dragon_type_icon)
             "dark" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_dark_type_icon)
             "fairy" ->  pokemonPrimaryTypeImage.setImageResource(com.app.pokedex_45486_44499.R.drawable.ic_pok_mon_fairy_type_icon)
         }
     }
}