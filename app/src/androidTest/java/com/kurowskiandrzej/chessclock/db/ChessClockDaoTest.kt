package com.kurowskiandrzej.chessclock.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.kurowskiandrzej.chessclock.common.TestConstants
import com.kurowskiandrzej.chessclock.getOrAwaitValueAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class ChessClockDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("testDatabase")
    lateinit var database: ChessClockDatabase

    private lateinit var dao: ChessClockDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.dao
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertTimeControlTest() = runBlockingTest {
        dao.insertTimeControl(
            TestConstants.TIME_CONTROL_NAME,
            TestConstants.STARTING_TIME,
            TestConstants.STARTING_TIME
        )
        val timeControls = dao.getTimeControls().getOrAwaitValueAndroidTest()
        assertThat(timeControls.filter { timeControl ->
            timeControl.name == TestConstants.TIME_CONTROL_NAME
        }).isNotEmpty()
    }

    @Test
    fun deleteTimeControlTest() = runBlockingTest {
        dao.insertTimeControl(
            TestConstants.TIME_CONTROL_NAME,
            TestConstants.STARTING_TIME,
            TestConstants.STARTING_TIME
        )
        var timeControls = dao.getTimeControls().getOrAwaitValueAndroidTest()
        dao.deleteTimeControl(timeControls.find { timeControl ->
            timeControl.name == TestConstants.TIME_CONTROL_NAME
        }!!.id)
        timeControls = dao.getTimeControls().getOrAwaitValueAndroidTest()
        assertThat(timeControls.filter { timeControl ->
            timeControl.name == TestConstants.TIME_CONTROL_NAME
        }).isEmpty()
    }
}