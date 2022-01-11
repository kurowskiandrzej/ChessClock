package com.kurowskiandrzej.chessclock.db.repository

import androidx.lifecycle.LiveData
import com.kurowskiandrzej.chessclock.db.entity.TimeControl

interface ChessClockRepository {

    suspend fun insertTimeControl(
        name: String,
        playerOneStartingTime: Int,
        playerTwoStartingTime: Int
    )

    suspend fun deleteTimeControlById(id: Long)

    fun getTimeControls(): LiveData<List<TimeControl>>
}