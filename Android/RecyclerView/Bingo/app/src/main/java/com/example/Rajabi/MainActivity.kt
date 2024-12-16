package com.example.Rajabi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.Rajabi.adapters.MonAdapter
import com.example.Rajabi.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MonAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler()
        fillRecycler()
    }

    private fun setupRecycler() {
        adapter = MonAdapter()
        binding.rvMonAdapter.adapter = adapter
        binding.rvMonAdapter.layoutManager = LinearLayoutManager(this)

        binding.rvMonAdapter.setHasFixedSize(true)
        binding.rvMonAdapter.addItemDecoration(
            DividerItemDecoration(binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL)
        )
    }

    private fun fillRecycler() {
        val items: MutableList<Bingo> = mutableListOf()
        val usedNumbers = mutableSetOf<Int>()

        for (tirage in 1..75) {
            val numero = generateUniqueNumber(usedNumbers)
            val letter = getLetterForNumber(numero)
            items.add(Bingo(tirage = tirage, numero = numero, letter = letter))
        }

        adapter.submitList(items)
    }

    private fun generateUniqueNumber(usedNumbers: MutableSet<Int>): Int {
        var numero: Int
        do {
            numero = Random.nextInt(1, 76)
        } while (usedNumbers.contains(numero))
        usedNumbers.add(numero)
        return numero
    }

    private fun getLetterForNumber(numero: Int): String {
        return when {
            numero in 1..15 -> "B"
            numero in 16..30 -> "I"
            numero in 31..45 -> "N"
            numero in 46..60 -> "G"
            else -> "O"
        }
    }
}
