package com.kurowskiandrzej.chessclock.view.recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.kurowskiandrzej.chessclock.databinding.ItemTimeControlBinding
import com.kurowskiandrzej.chessclock.db.entity.TimeControl

class TimeControlViewHolder(
    private val binding: ItemTimeControlBinding,
    private val timeControlClickListener: TimeControlClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(timeControl: TimeControl) {
        binding.apply {
            tvName.text = timeControl.name
            layoutRoot.setOnClickListener {
                timeControlClickListener.onTimeControlClick(timeControl.id)
            }
        }
    }
}