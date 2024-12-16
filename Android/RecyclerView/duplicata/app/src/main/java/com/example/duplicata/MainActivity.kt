package com.example.Rajabi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duplicata.adapters.NumberAdapter
import com.example.duplicata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NumberAdapter
    private var numberList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the list with numbers from 1 to 10
        numberList.addAll(1..10)

        // Set up the RecyclerView and the adapter
        adapter = NumberAdapter(numberList) { position ->
            duplicateItem(position)  // Handle item duplication on button click
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    // Function to duplicate the clicked item
    private fun duplicateItem(position: Int) {
        val item = numberList[position]  // Get the number at the clicked position
        numberList.add(position + 1, item)  // Insert the duplicate next to it
        adapter.notifyItemInserted(position + 1)  // Notify the adapter to update the list view
    }
}
