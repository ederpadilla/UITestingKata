package com.example.espressokata

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RecyclerViewActivityTest{
    @get:Rule
    var activityRule = IntentsTestRule(RecyclerViewActivity::class.java)

    @Test
    fun recyclerViewFirstTest() {
        onView(withText("Monica"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewScrollTest() {
        onView(withId(R.id.recyclerActivityRv))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))

        onView(withText("Pablo"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewScrollClickTest() {
        onView(withId(R.id.recyclerActivityRv))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(19, click()))

        onView(withText("Pablo"))
            .check(matches(isDisplayed()))
    }

}