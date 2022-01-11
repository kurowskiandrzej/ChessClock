package com.kurowskiandrzej.chessclock.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kurowskiandrzej.chessclock.R
import com.kurowskiandrzej.chessclock.databinding.FragmentClockBinding

class ClockFragment : Fragment(R.layout.fragment_clock) {
    private var _binding: FragmentClockBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentClockBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}