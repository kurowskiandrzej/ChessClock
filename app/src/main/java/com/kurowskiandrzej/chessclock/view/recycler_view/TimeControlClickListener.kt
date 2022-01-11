package com.kurowskiandrzej.chessclock.view.recycler_view

interface TimeControlClickListener {
    fun onTimeControlClick(id: Long)
    fun onTimeControlDeleteClick(id: Long)
    fun onTimeControlEditClick(id: Long)
}