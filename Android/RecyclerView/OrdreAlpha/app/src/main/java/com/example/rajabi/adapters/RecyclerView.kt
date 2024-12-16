import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajabi.R

class NameAdapter(private val nameList: MutableList<String>, private val onItemMoved: (Int, Int) -> Unit) : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val name = nameList[position]
        holder.bind(name)

        // Handle "Up" button click
        holder.upButton.setOnClickListener {
            if (position > 0) {
                // Move the item up
                onItemMoved(position, position - 1)
            }
        }

        // Handle "Down" button click
        holder.downButton.setOnClickListener {
            if (position < nameList.size - 1) {
                // Move the item down
                onItemMoved(position, position + 1)
            }
        }
    }

    override fun getItemCount(): Int = nameList.size

    inner class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val upButton: Button = view.findViewById(R.id.upButton)
        val downButton: Button = view.findViewById(R.id.downButton)

        fun bind(name: String) {
            nameTextView.text = name
        }
    }
}
