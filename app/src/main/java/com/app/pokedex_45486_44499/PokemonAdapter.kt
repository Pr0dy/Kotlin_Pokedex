package com.app.pokedex_45486_44499

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(val listOfPokemonModel: List<PokemonModel>): RecyclerView.Adapter<PokemonRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonRecyclerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PokemonRecyclerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int =  listOfPokemonModel.size

}