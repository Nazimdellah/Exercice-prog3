package com.example.Rajabi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.Rajabi.Bingo
import com.example.Rajabi.databinding.MonItemBinding

class MonAdapter : RecyclerView.Adapter<MonAdapter.BingoViewHolder>() {

    private var items: List<Bingo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingoViewHolder {
        val binding = MonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BingoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BingoViewHolder, position: Int) {
        val bingoItem = items[position]
        holder.bind(bingoItem)
    }

    override fun getItemCount(): Int = items.size

    fun submitList(list: List<Bingo>) {
        items = list
        notifyDataSetChanged()
    }

    class BingoViewHolder(private val binding: MonItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bingoItem: Bingo) {
            binding.tirage.text = "Tirage: ${bingoItem.tirage}"
            binding.num1.text = "Numéro: ${bingoItem.numero}"
            binding.letter.text = "Lettre: ${bingoItem.letter}"
        }
    }
}
