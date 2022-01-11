package com.kurowskiandrzej.chessclock.view.fragment

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.kurowskiandrzej.chessclock.R
import com.kurowskiandrzej.chessclock.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@MediumTest
@HiltAndroidTest
class HomeFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testNavigationFromHomeToTimeControlEditor() {
        val mockNavController = Mockito.mock(NavController::class.java)

        launchFragmentInHiltContainer<HomeFragment> {
            Navigation.setViewNavController(requireView(), mockNavController)
        }

        Espresso.onView(ViewMatchers.withId(R.id.btn_open_time_control_editor))
            .perform(ViewActions.click())

        Mockito.verify(mockNavController).navigate(
            HomeFragmentDirections.actionHomeFragmentToClockEditorFragment()
        )
    }
}