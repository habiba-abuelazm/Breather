package com.example.takeabreather.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.takeabreather.ExportActivity
import com.example.takeabreather.MainActivity
import com.example.takeabreather.R
import com.example.takeabreather.ResourcesActivity
import com.example.takeabreather.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private var _binding: FragmentSettingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val itemList = listOf("Notifications", "Resources", "Export", "History", "About", "Log Out")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        settingsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.settingsList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ItemAdapter(itemList)

        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView4)

        init {
            // Set click listener for the TextView
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
                "Notifications" -> {
//                    val notificationsIntent = Intent(requireContext(), NotificationsActivity::class.java)
//                    startActivity(notificationsIntent)
                }
                "Resources" -> {
                    val resourcesIntent = Intent(requireContext(), ResourcesActivity::class.java)
                    startActivity(resourcesIntent)
                }
                "Export" -> {
                    val exportIntent = Intent(requireContext(), ExportActivity::class.java)
                    startActivity(exportIntent)
                }
                "History" -> {
//                    val resourcesIntent = Intent(requireContext(), HistoryActivity::class.java)
//                    startActivity(resourcesIntent)
                }
                "About" -> {
//                    val resourcesIntent = Intent(requireContext(), AboutActivity::class.java)
//                    startActivity(resourcesIntent)
                }
                "Log Out" -> {
                    val logOutIntent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(logOutIntent)
                }
            }
        }
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

}