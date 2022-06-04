package com.app.pokedex_45486_44499

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val pokemon = listOf<PokemonModel>(
        PokemonModel("pokemon1",1,"SomeURl"),
        PokemonModel("pokemon2",2,"SomeURl"),
        PokemonModel("pokemon3",3,"SomeURl"),
        PokemonModel("pokemon4",4,"SomeURl"),
        PokemonModel("pokemon5",5,"SomeURl"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}