package com.example.duplicata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.duplicata.R

class NumberAdapter(private val numberList: MutableList<Int>,
                    private val onDuplicateClicked: (Int) -> Unit // A lambda function for duplication logic
) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    // Creates a new ViewHolder for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return NumberViewHolder(view)
    }

    // Bind the data to the ViewHolder
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val number = numberList[position]
        holder.bind(number)

        // Set up the listener for the "Duplicate" button
        holder.duplicateButton.setOnClickListener {
            onDuplicateClicked(position)  // This triggers the duplication logic
        }
    }

    // Return the size of the list
    override fun getItemCount(): Int = numberList.size

    // ViewHolder class that holds the reference to the views for each item
    inner class NumberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberTextView: TextView = view.findViewById(R.id.numberTextView)
        val duplicateButton: Button = view.findViewById(R.id.duplicateButton)

        fun bind(number: Int) {
            numberTextView.text = number.toString()
        }
    }
}