package com.kurowskiandrzej.chessclock.db.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kurowskiandrzej.chessclock.db.entity.TimeControl

class ChessClockRepositoryFake: ChessClockRepository {

    private val timeControls = mutableListOf<TimeControl>()
    private val timeControlsLiveData = MutableLiveData<List<TimeControl>>(timeControls)

    override suspend fun insertTimeControl(name: String, playerOneStartingTime: Int, playerTwoStartingTime: Int) {
        timeControls.add(
            TimeControl(
                0,
                name,
                "0",
                playerOneStartingTime,
                playerTwoStartingTime
            )
        )
    }

    override suspend fun deleteTimeControlById(id: Long) {
        timeControls.removeIf { timeControl -> timeControl.id == id }
    }

    override fun getTimeControls(): LiveData<List<TimeControl>> {
        return timeControlsLiveData
    }
}