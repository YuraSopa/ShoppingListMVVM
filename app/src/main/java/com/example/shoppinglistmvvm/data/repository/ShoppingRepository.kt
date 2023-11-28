package com.example.shoppinglistmvvm.data.repository

import com.example.shoppinglistmvvm.data.db.ShoppingDatabase
import com.example.shoppinglistmvvm.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {

    suspend fun updateAndInsert(item: ShoppingItem) = db.getShoppingDao().updateAndInsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}