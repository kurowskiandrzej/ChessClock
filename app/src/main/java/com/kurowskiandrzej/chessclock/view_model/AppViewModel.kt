package com.kurowskiandrzej.chessclock.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepository
import com.kurowskiandrzej.chessclock.view_model.use_case.ChessClockUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val useCase: ChessClockUseCases
) : ViewModel() {

    val timeControls = useCase.getTimeControls()

    fun insertTimeControl(
        name: String,
        playerOneStartingTime: Int,
        playerTwoStartingTime: Int
    ) = viewModelScope.launch {
        useCase.insertTimeControl(
            name,
            playerOneStartingTime,
            playerTwoStartingTime
        )
    }

    fun deleteTimeControlById(id: Long) = viewModelScope.launch {
        useCase.deleteTimeControlById(id)
    }
}