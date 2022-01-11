package com.kurowskiandrzej.chessclock.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kurowskiandrzej.chessclock.R
import com.kurowskiandrzej.chessclock.databinding.FragmentTimeControlEditorBinding

class TimeControlEditorFragment : Fragment(R.layout.fragment_time_control_editor) {
    private var _binding: FragmentTimeControlEditorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTimeControlEditorBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnOpenClock.setOnClickListener {
            findNavController().navigate(
                TimeControlEditorFragmentDirections.actionClockEditorFragmentToClockFragment()
            )
        }

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}