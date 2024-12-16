package com.example.Rajabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.Rajabi.databinding.MonItemBinding

data class Album(
    val id: Int,
    val name: String,
    val artistName: String,
)

class MonAdapter : ListAdapter<Album, MonAdapter.MonItemViewHolder>(MonItemDiffCallback) {

    inner class MonItemViewHolder(private val binding: MonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Album) {
            binding.tvElement.text = item.artistName // Assuming this is the TextView for the artist name
            binding.tvAlbum.text = item.name // Assuming this is the TextView for the album name

            binding.tvElement.setOnClickListener {
                val intent: Intent = Intent(binding.root.context, Detail::class.java).apply {
                    putExtra("album_id", item.id)
                    putExtra("album_name", item.name)
                    putExtra("artist_name", item.artistName)
                }
                binding.root.context.startActivity(intent)
            }

            binding.btnSupprimer.setOnClickListener {
                removeItem(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonItemViewHolder {
        val binding: MonItemBinding = MonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonItemViewHolder, position: Int) {
        val item: Album = getItem(position) // Retrieve the Album object from the list
        holder.bind(item) // Bind the Album to the ViewHolder
    }

    // Method to remove an item from the adapter
    private fun removeItem(position: Int) {
        if (position >= 0 && position < itemCount) {
            // Create a mutable copy of the current list
            val updatedList = currentList.toMutableList()
            updatedList.removeAt(position)
            submitList(updatedList) // Submit the updated list
        }
    }
}

object MonItemDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id // Compare based on unique ID
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem // Compare the entire Album object
    }
}
