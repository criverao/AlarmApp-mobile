package com.example.alarmapp.ui.alarms

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentCreateAlarmBinding
import com.google.android.material.datepicker.MaterialDatePicker.InputMode
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

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

        val textviewDate: TextView?
        val cal = Calendar.getInstance()

        textviewDate = binding.textViewDate1

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "MM/dd/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                textviewDate.text = sdf.format(cal.time)
            }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        textviewDate.setOnClickListener {
            context?.let { it1 ->
                DatePickerDialog(
                    it1,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        val textviewTimePicker: TextView?

        textviewTimePicker = binding.textViewTimepicker

        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(context,
            { _, hourOfDay, minute -> textviewTimePicker.text =
                String.format("%d : %d", hourOfDay, minute, INPUT_MODE_KEYBOARD) },
            hour, minute, false
        )

        mTimePicker.setTitle("Hora")

        textviewTimePicker.setOnClickListener {
            mTimePicker.show()
        }

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