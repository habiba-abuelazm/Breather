package com.example.takeabreather.ui.measure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeasureViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Device successfully connected!"
    }
    val text: LiveData<String> = _text
}