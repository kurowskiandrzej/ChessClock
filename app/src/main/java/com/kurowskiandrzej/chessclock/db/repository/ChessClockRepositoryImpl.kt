package com.kurowskiandrzej.chessclock.db.repository

import androidx.lifecycle.LiveData
import com.kurowskiandrzej.chessclock.db.ChessClockDao
import com.kurowskiandrzej.chessclock.db.entity.TimeControl
import javax.inject.Inject

class ChessClockRepositoryImpl @Inject constructor(
    private val dao: ChessClockDao
) : ChessClockRepository {

    override suspend fun insertTimeControl(
        name: String,
        playerOneStartingTime: Int,
        playerTwoStartingTime: Int
    ) {
        dao.insertTimeControl(
            name,
            playerOneStartingTime,
            playerTwoStartingTime
        )
    }

    override suspend fun deleteTimeControlById(id: Long) {
        dao.deleteTimeControl(id)
    }

    override fun getTimeControls(): LiveData<List<TimeControl>> {
        return dao.getTimeControls()
    }
}