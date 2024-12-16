package com.example.ordrealpha

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rajabi.adapters.PersonneAdapter
import com.example.rajabi.databinding.ActivityMainBinding
import com.example.rajabidata.Personne
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonneAdapter
    private var personnesList: MutableList<Personne> = mutableListOf(
        Personne("Alice"),
        Personne("Bob"),
        Personne("Charlie"),
        Personne("David"),
        Personne("Eva")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        shuffleList()

        // Vérifie si la liste est triée au démarrage
        checkIfSorted()
    }

    private fun setupRecyclerView() {
        adapter = PersonneAdapter(personnesList) { position, moveUp ->
            if (moveUp) {
                if (position > 0) {
                    val temp = personnesList[position]
                    personnesList[position] = personnesList[position - 1]
                    personnesList[position - 1] = temp
                    adapter.notifyItemMoved(position, position - 1)
                }
            } else {
                if (position < personnesList.size - 1) {
                    val temp = personnesList[position]
                    personnesList[position] = personnesList[position + 1]
                    personnesList[position + 1] = temp
                    adapter.notifyItemMoved(position, position + 1)
                }
            }
            checkIfSorted()
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun shuffleList() {
        personnesList.shuffle(Random)
        adapter.notifyDataSetChanged()
    }

    // Vérifie si la liste est triée par ordre alphabétique
    private fun checkIfSorted() {
        if (personnesList.map { it.prenom }.sorted() == personnesList.map { it.prenom }) {
            // Si la liste est triée
            showVictoryDialog()
            shuffleList() // Mélanger la liste à nouveau
        }
    }

    // Affiche le dialogue de félicitations
    private fun showVictoryDialog() {
        AlertDialog.Builder(this)
            .setTitle("Félicitations !")
            .setMessage("La liste est maintenant triée par ordre alphabétique.")
            .setPositiveButton("Recommencer") { dialog, _ ->
                shuffleList()
                dialog.dismiss()
            }
            .show()
    }
}
