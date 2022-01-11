package com.kurowskiandrzej.chessclock.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.kurowskiandrzej.chessclock.db.entity.TimeControl

@Dao
interface ChessClockDao {

    @Query("""
        INSERT INTO TimeControl (name, creationDate, playerOneStartingTime, playerTwoStartingTime)
        VALUES (:name, CURRENT_TIMESTAMP, :playerOneStartingTime, :playerTwoStartingTime)
    """)
    suspend fun insertTimeControl(name: String, playerOneStartingTime: Int, playerTwoStartingTime: Int)

    @Query("""
        DELETE FROM TimeControl
        WHERE id = :id
    """)
    suspend fun deleteTimeControl(id: Long)

    @Query("""
        SELECT * FROM TimeControl
    """)
    fun getTimeControls(): LiveData<List<TimeControl>>
}