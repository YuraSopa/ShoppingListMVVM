package com.example.shoppinglistmvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.example.shoppinglistmvvm.databinding.ShoppingItemBinding

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : Adapter<ShoppingItemAdapter.ShoppingItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemHolder {
        val binding = ShoppingItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShoppingItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemHolder, position: Int) {
        val currentItem = items[position]

        holder.binding.tvName.text = currentItem.name
        holder.binding.tvAmount.text = "${currentItem.amount}"

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }
        holder.binding.ivRemove.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
            }
            viewModel.updateAndInsert(currentItem)
        }
        holder.binding.ivAdd.setOnClickListener {
            currentItem.amount++
            viewModel.updateAndInsert(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingItemHolder(
        val binding: ShoppingItemBinding
    ) : ViewHolder(binding.root)
}