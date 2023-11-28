package com.example.shoppinglistmvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistmvvm.data.repository.ShoppingRepository

class ShoppingViewModelFactory(
    private val repository: ShoppingRepository
) : ViewModelProvider.AndroidViewModelFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModelFactory(repository) as T
    }
}