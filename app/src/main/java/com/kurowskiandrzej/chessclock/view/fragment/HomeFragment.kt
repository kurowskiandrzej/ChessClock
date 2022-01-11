package com.kurowskiandrzej.chessclock.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurowskiandrzej.chessclock.R
import com.kurowskiandrzej.chessclock.databinding.FragmentHomeBinding
import com.kurowskiandrzej.chessclock.view.recycler_view.TimeControlAdapter
import com.kurowskiandrzej.chessclock.view.recycler_view.TimeControlClickListener
import com.kurowskiandrzej.chessclock.view_model.AppViewModel

class HomeFragment : Fragment(R.layout.fragment_home),
    TimeControlClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val appViewModel by lazy { ViewModelProvider(requireActivity())[AppViewModel::class.java] }
    private val timeControlAdapter by lazy { TimeControlAdapter(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = timeControlAdapter
        }

        binding.btnOpenTimeControlEditor.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToClockEditorFragment()
            )
        }

        subscribeToViewModel()

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun subscribeToViewModel() {
        appViewModel.timeControls.observe(viewLifecycleOwner, {
            timeControlAdapter.timeControls = it
        })
    }

    override fun onTimeControlClick(id: Long) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToClockFragment()
        )
    }

    override fun onTimeControlDeleteClick(id: Long) {
        appViewModel.deleteTimeControlById(id)
    }

    override fun onTimeControlEditClick(id: Long) {
        // TODO("Not yet implemented")
    }
}