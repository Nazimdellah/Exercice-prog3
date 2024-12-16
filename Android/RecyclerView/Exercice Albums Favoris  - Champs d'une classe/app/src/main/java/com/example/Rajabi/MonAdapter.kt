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



            binding.btnMonBouton.setOnClickListener {
                val intent: Intent = Intent(binding.root.context, ActivitySecond::class.java)
                // On ajoute le nom de l'élément à l'intent
                intent.putExtra("name", item.name)
                // Démarrer l'activité SecondActivity
                binding.root.context.startActivity(intent)
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
}

object MonItemDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id // Compare based on unique ID
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem // Compare the entire Album object
    }
}
