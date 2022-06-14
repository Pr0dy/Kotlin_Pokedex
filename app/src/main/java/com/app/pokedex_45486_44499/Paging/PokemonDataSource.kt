package com.app.pokedex_45486_44499.Paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.app.pokedex_45486_44499.Networking.PokemonModel.PokemonModel
import com.app.pokedex_45486_44499.Room.PokeRepository

internal class PokemonDataSource(private val repository: PokeRepository):
    PagingSource<Int, PokemonModel>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonModel> {
        val nextPage = params.key ?: 1
        val pokemon = repository.getPokemonForPaging(nextPage * params.loadSize + 1, params.loadSize)

        return LoadResult.Page(
            data = pokemon,
            prevKey = if (nextPage == 0) null else nextPage - 1,
            nextKey = if (pokemon.isEmpty()) null else nextPage + 1
        )

    }
}