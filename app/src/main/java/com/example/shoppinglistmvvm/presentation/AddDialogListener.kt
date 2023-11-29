package com.example.shoppinglistmvvm.presentation

import com.example.shoppinglistmvvm.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}