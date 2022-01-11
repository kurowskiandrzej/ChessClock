package com.kurowskiandrzej.chessclock.view_model.use_case
import com.kurowskiandrzej.chessclock.common.Constants
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import com.kurowskiandrzej.chessclock.error_handling.exception.EmptyInputFieldException
import com.kurowskiandrzej.chessclock.error_handling.exception.InvalidStartingTimeException
import com.kurowskiandrzej.chessclock.error_handling.exception.InvalidStartingTimeStatus
import javax.inject.Inject

class InsertTimeControlUseCase @Inject constructor(
    private val repository: ChessClockRepository
) {
    suspend operator fun invoke(
        name: String,
        playerOneStartingTime: Int,
        playerTwoStartingTime: Int
    ) {
        if (name.isEmpty()) {
            throw EmptyInputFieldException("name")
        } else if (
            playerOneStartingTime < Constants.MINIMAL_STARTING_TIME ||
            playerTwoStartingTime < Constants.MINIMAL_STARTING_TIME
        ) {
            throw InvalidStartingTimeException(InvalidStartingTimeStatus.TOO_LOW)
        } else if (
            playerOneStartingTime > Constants.MAXIMAL_STARTING_TIME ||
            playerTwoStartingTime > Constants.MAXIMAL_STARTING_TIME
        ) {
            throw InvalidStartingTimeException(InvalidStartingTimeStatus.TOO_HIGH)
        }
        else {
            repository.insertTimeControl(
                name,
                playerOneStartingTime,
                playerTwoStartingTime
            )
        }
    }
}