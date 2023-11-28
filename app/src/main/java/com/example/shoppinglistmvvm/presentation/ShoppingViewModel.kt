package com.example.shoppinglistmvvm.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.example.shoppinglistmvvm.data.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun updateAndInsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.updateAndInsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}