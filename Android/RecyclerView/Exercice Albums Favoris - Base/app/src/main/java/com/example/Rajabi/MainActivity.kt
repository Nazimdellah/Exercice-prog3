package com.example.Rajabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Rajabi.databinding.ActivityMainBinding

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
        adapter = MonAdapter() // Créer l'adapteur
        binding.rvMonAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
        binding.rvMonAdapter.setHasFixedSize(true) // Option pour améliorer les performances


            DividerItemDecoration(
                binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL
            )

    }
    private fun fillRecycler() {
        val items: MutableList<String> = mutableListOf(
            "Album 1: Artist A",
            "Album 2: Artist B",
            "Album 3: Artist C",
            "Album 4: Artist D",
            "Album 5: Artist E",
            "Album 6: Artist F",
            "Album 7: Artist G",
            "Album 8: Artist H",
            "Album 9: Artist I",
            "Album 10: Artist J",
        )

        adapter.submitList(items) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }
    }
