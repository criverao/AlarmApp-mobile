package com.example.alarmapp.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alarmapp.R
import com.example.alarmapp.databinding.FragmentAlarmsBinding

class AlarmsFragment : Fragment() {

    private var _binding: FragmentAlarmsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(AlarmsViewModel::class.java)

        _binding = FragmentAlarmsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textAlarmas
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        binding.addAlbumButton.setOnClickListener {
            findNavController().navigate(R.id.action_create_alarm)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}