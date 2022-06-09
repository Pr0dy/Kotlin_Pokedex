package com.app.pokedex_45486_44499.Activities

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.R

class PokemonAdapter(private val listOfPokemonModel: MutableList<PokemonModel>): RecyclerView.Adapter<PokemonRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonRecyclerViewHolder {
        val layout = LayoutInflater.from(parent.context)
        return PokemonRecyclerViewHolder(layout.inflate(R.layout.pokemon_cell, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonRecyclerViewHolder, position: Int) {
        val pokemon = listOfPokemonModel[position]
        holder.render(pokemon)
    }

    override fun getItemCount(): Int = listOfPokemonModel.size

}