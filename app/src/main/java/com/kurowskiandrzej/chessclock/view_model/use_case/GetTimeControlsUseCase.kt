package com.kurowskiandrzej.chessclock.view_model.use_case

import androidx.lifecycle.LiveData
import com.kurowskiandrzej.chessclock.db.entity.TimeControl
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import javax.inject.Inject

class GetTimeControlsUseCase @Inject constructor(
    private val repository: ChessClockRepository
) {
    operator fun invoke(): LiveData<List<TimeControl>> {
        return repository.getTimeControls()
    }
}