package com.app.pokedex_45486_44499.Activities
import android.graphics.Color
import android.view.View
import android.view.View.*
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.R
import com.bumptech.glide.Glide


class PokemonRecyclerViewHolder(val pokemonCellView: View): RecyclerView.ViewHolder(pokemonCellView) {

     val pokemonName = pokemonCellView.findViewById<TextView>(com.app.pokedex_45486_44499.R.id.pokemonName)
     val pokemonNumber = pokemonCellView.findViewById<TextView>(com.app.pokedex_45486_44499.R.id.pokemonNumber)
     val pokemonImage = pokemonCellView.findViewById<ImageView>(R.id.pokemonSpriteImage)
     val pokemonPrimaryTypeImage = pokemonCellView.findViewById<ImageView>(R.id.pokemonPrimaryType)
     val pokemonFavoriteIcon = pokemonCellView.findViewById<ImageButton>(R.id.favoritePokemon)


    fun render(pokemon: PokemonModel){
            pokemonName.text = pokemon.name.capitalize()
            pokemonNumber.text = "#${pokemon.id}"
            Glide.with(pokemonImage.context).load(pokemon.sprites.front_default).into(pokemonImage)
            setTypeImage(pokemon.types[0].type.name)


        if (pokemon.isFavorite) pokemonFavoriteIcon.setBackgroundResource(R.drawable.star)
            else pokemonFavoriteIcon.setBackgroundResource(R.drawable.empty)

            pokemonFavoriteIcon.setOnClickListener{
               setFavoriteIcon(pokemon)
            }
    }

     fun setFavoriteIcon(pokemon: PokemonModel){
         if (pokemon.isFavorite){
             pokemon.isFavorite = false
             pokemonFavoriteIcon.setBackgroundResource(R.drawable.empty)

         } else {
             pokemon.isFavorite = true
             pokemonFavoriteIcon.setBackgroundResource(R.drawable.star)
         }
     }

     fun setTypeImage(pokemonType: String) {
         when (pokemonType){
             "normal" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_normal_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(168,168,165))
             }
             "fighting" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_fighting_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(177,61,79))
             }
             "flying" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_flying_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(164,145,234))
             }
             "poison" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_poison_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(148,70,145))
             }
             "ground" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_ground_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(255,193,117))
             }
             "rock" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_rock_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(180,161,75))
             }
             "bug" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_bug_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(171,185,66))
             }
             "ghost" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_ghost_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(108,89,148))
             }
             "steel" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_steel_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(180,180,202))
             }
             "fire" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_fire_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(242,171,101))
             }
             "water" ->  {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_water_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(112,143,233))
             }
             "grass" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_grass_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(139,198,96))
             }
             "electric" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_electric_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(242,210,84))
             }
             "psychic" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_psychic_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(230,99,136))
             }
             "ice" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_ice_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(166,214,215))
             }
             "dragon" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_dragon_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(105,59,239))
             }
             "dark" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_dark_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(108,89,74))
             }
             "fairy" -> {
                 pokemonPrimaryTypeImage.setImageResource(R.drawable.ic_pok_mon_fairy_type_icon)
                 pokemonCellView.setBackgroundColor(Color.rgb(226,157,172))
             }
         }
     }
}
