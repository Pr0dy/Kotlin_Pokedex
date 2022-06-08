package com.app.pokedex_45486_44499.Activities.ViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.pokedex_45486_44499.Networking.ApiRequests.PokeRepository

class MainActivityViewModelFactory(private val repository: PokeRepository):  ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}