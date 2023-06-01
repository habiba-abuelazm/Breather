package com.example.takeabreather.ui.measure

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.takeabreather.LoadingActivity
import com.example.takeabreather.MainActivity
import com.example.takeabreather.R
import com.example.takeabreather.databinding.FragmentMeasureBinding

class MeasureFragment : Fragment(R.layout.fragment_measure) {

    private var _binding: FragmentMeasureBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val measureViewModel =
            ViewModelProvider(this).get(MeasureViewModel::class.java)

        _binding = FragmentMeasureBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        measureViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val measureButton: Button = view.findViewById(R.id.button2)
        measureButton.setOnClickListener {
            val intent = Intent(requireContext(), LoadingActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun onClickMeasure(view: View) {
        val intent = Intent(requireContext(), LoadingActivity::class.java)
        startActivity(intent)
    }


}