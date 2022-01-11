package com.kurowskiandrzej.chessclock.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Holds information about how much time in milliseconds
 * each player receives to complete a game
 * */
@Entity
data class TimeControl(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val creationDate: String,
    val playerOneStartingTime: Int,
    val playerTwoStartingTime: Int
)
