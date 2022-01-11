package com.kurowskiandrzej.chessclock.view_model.use_case

import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import javax.inject.Inject

class ChessClockUseCases @Inject constructor(
    val insertTimeControl: InsertTimeControlUseCase,
    val getTimeControls: GetTimeControlsUseCase,
    val deleteTimeControlById: DeleteTimeControlByIdUseCase
) {
    constructor(
        repository: ChessClockRepository
    ) : this(
        insertTimeControl = InsertTimeControlUseCase(repository),
        getTimeControls = GetTimeControlsUseCase(repository),
        deleteTimeControlById = DeleteTimeControlByIdUseCase(repository)
    )
}