package com.example.alarmapp.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentAlarmsBinding

class AlarmsFragment : Fragment() {

    private var _binding: FragmentAlarmsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAlarmsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.deleteButton.setOnClickListener {
            findNavController().navigate(R.id.action_delete_alarm)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}