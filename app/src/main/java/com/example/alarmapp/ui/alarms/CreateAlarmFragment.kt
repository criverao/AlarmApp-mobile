package com.example.alarmapp.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.alarmapp.databinding.FragmentCreateAlarmBinding

class CreateAlarmFragment : Fragment() {

    private var _binding: FragmentCreateAlarmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        /*val homeViewModel =
                ViewModelProvider(this).get(AlarmasViewModel::class.java)*/

        _binding = FragmentCreateAlarmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textAlarmas
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}