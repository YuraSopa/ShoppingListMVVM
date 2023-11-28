package com.example.shoppinglistmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistmvvm.R
import com.example.shoppinglistmvvm.data.db.ShoppingDatabase
import com.example.shoppinglistmvvm.data.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[ShoppingViewModel::class.java]


    }
}