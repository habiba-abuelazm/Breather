package com.example.takeabreather

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import com.example.takeabreather.ui.dashboard.DashboardFragment
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDate: EditText
    private val calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)
    }

    fun onClickContinue(v: View) {
        setContentView(R.layout.view_signup)
        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)

        editTextDate = findViewById(R.id.editTextDate)

        editTextDate.setOnClickListener {
            showDatePickerDialog()
        }

        val items = listOf("Select your gender", "Woman", "Man", "Two spirit", "Non-binary", "Prefer not to respond")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private val dateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            // Update the EditText field with the selected date
            val selectedDate = "${month + 1}/$dayOfMonth/$year"
            editTextDate.setText(selectedDate)
        }

    fun onClickRegister(v: View) {
        setContentView(R.layout.activity_login)
        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)
    }

    fun onClickSignIn(v: View) {

        val loggedInIntent = Intent(this, LoggedInActivity::class.java)
        startActivity(loggedInIntent)

    }


}