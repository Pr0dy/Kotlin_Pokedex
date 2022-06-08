package com.app.pokedex_45486_44499.Networking.ApiRequests
import com.app.pokedex_45486_44499.Networking.BASE_URL

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


object PokeAPIClient {
    private val setupPokemonRetrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    val pokeAPI: PokeAPIRequests by lazy{
        setupPokemonRetrofit.create(PokeAPIRequests::class.java)
    }
}
