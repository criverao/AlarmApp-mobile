package com.example.alarmapp.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentCreateAlarmBinding

class CreateAlarmFragment : Fragment() {

    private var _binding: FragmentCreateAlarmBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.alarm_repeats_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            _binding?.alarmRepeatSpinner?.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.alert_types_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            _binding?.alertTypesSpinner?.adapter = adapter
        }

        binding.alarmCreateButton.setOnClickListener {
            findNavController().navigate(R.id.create_alarm_success_notification)
        }

        _binding?.alarmCancelButton?.setOnClickListener {
            NavHostFragment.findNavController(this@CreateAlarmFragment).navigateUp()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}