package com.omoraless.cvandroid.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.omoraless.cvandroid.R
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsAnything.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class RecyclerViewTest {
        /**
         * Use [ActivityScenario] to create and launch the activity under test. This is a
         * replacement for [androidx.test.rule.ActivityTestRule].
         */
        @Rule @JvmField
        var activityScenarioRule: ActivityScenarioRule<CVActivity> =
            ActivityScenarioRule<CVActivity>(
                CVActivity::class.java
            )

    @Test
    fun testRecyclerViewScroll(){
        onView(withClassName(`is`(RecyclerView::class.java.canonicalName)))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(1))
            .check(matches(anything()))

    }

    @Test
    fun testScreenScroll(){
        onView(withId(R.id.constraint_recycler_view))
            .perform(scrollTo(), click())
    }
}