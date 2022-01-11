package com.kurowskiandrzej.chessclock.view_model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kurowskiandrzej.chessclock.MainCoroutineRule
import com.kurowskiandrzej.chessclock.common.TestConstants
import com.kurowskiandrzej.chessclock.db.entity.TimeControl
import com.kurowskiandrzej.chessclock.db.repository.ChessClockRepositoryFake
import com.kurowskiandrzej.chessclock.getOrAwaitValueTest
import com.kurowskiandrzej.chessclock.view_model.use_case.ChessClockUseCases
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AppViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var appViewModel: AppViewModel

    @Before
    fun setup() {
        val repositoryFake = ChessClockRepositoryFake()
        appViewModel = AppViewModel(ChessClockUseCases(repositoryFake))
    }

    @Test
    fun insertValidTimeControl() {
        appViewModel.insertTimeControl(
            TestConstants.TIME_CONTROL_NAME,
            TestConstants.STARTING_TIME,
            TestConstants.STARTING_TIME
        )
        val timeControls = appViewModel.timeControls.getOrAwaitValueTest()
        assertThat(timeControls).contains(
            TimeControl(
                0,
                TestConstants.TIME_CONTROL_NAME,
                "0",
                TestConstants.STARTING_TIME,
                TestConstants.STARTING_TIME
            )
        )
    }
}