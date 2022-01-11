package com.kurowskiandrzej.chessclock.view_model.use_case

import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import javax.inject.Inject

class DeleteTimeControlByIdUseCase @Inject constructor(
    private val repository: ChessClockRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteTimeControlById(id)
    }
}