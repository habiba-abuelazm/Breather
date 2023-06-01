package com.example.takeabreather

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.takeabreather.R.id.resourcesList

class ResourcesActivity : AppCompatActivity() {

    private val itemList = listOf("Mental Health Meter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resources)
        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)

        val recyclerView: RecyclerView = findViewById(resourcesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemList)

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    private inner class ItemAdapter(private val items: List<String>) :
        RecyclerView.Adapter<ItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return ItemViewHolder(view)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = items[position]
            holder.textView.text = item
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }

    private inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView4)

        init {
            textView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Handle the click event here
                    val item = itemList[position]
                    // Example: Show a toast with the clicked item's text
                    Toast.makeText(itemView.context, "Clicked: $item", Toast.LENGTH_SHORT).show()
                    handleItemClick(item)
                }
            }
        }

        private fun handleItemClick(item: String) {
            when (item) {
                "Mental Health Meter" -> {
                    val cmhaUrl = "https://cmha.ca/find-info/mental-health/check-in-on-your-mental-health/mental-health-meter/"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(cmhaUrl))
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}