package com.kurowskiandrzej.chessclock.view.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kurowskiandrzej.chessclock.databinding.ItemTimeControlBinding
import com.kurowskiandrzej.chessclock.db.entity.TimeControl

class TimeControlAdapter(
    private val timeControlClickListener: TimeControlClickListener
): RecyclerView.Adapter<TimeControlViewHolder>() {

    private val diffUtil = object: DiffUtil.ItemCallback<TimeControl>() {
        override fun areItemsTheSame(oldItem: TimeControl, newItem: TimeControl): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TimeControl, newItem: TimeControl): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerListDiffer = AsyncListDiffer(this, diffUtil)

    var timeControls: List<TimeControl>
        get() = recyclerListDiffer.currentList
        set(list) = recyclerListDiffer.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeControlViewHolder {
        return TimeControlViewHolder(
            ItemTimeControlBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            timeControlClickListener
        )
    }

    override fun onBindViewHolder(holder: TimeControlViewHolder, position: Int) {
        holder.bind(timeControls[position])
    }

    override fun getItemCount(): Int {
        return timeControls.size
    }
}