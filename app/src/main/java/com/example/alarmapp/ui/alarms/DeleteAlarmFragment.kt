package com.example.alarmapp.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentDeleteAlarmBinding

class DeleteAlarmFragment : Fragment() {

    private var _binding: FragmentDeleteAlarmBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeleteAlarmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.acceptButton.setOnClickListener {
            findNavController().navigate(R.id.action_accept)
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_cancel)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}