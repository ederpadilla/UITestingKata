package com.example.espressokata

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class Main2ActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(Main2Activity::class.java)

    @Test
    fun isDisplayedOnTheScreenTest() {
        onView(withText("My first Espresso test"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun isDisplayedOnTheScreenWithIdTest() {
        onView(withId(R.id.activityMain2TvMiFirstTest))
            .check(matches(isDisplayed()))
    }

    @Test
    fun ensureResetWorkTest() {
        onView(withId(R.id.activityMain2BtReset))
            .perform(click())

        onView(withId(R.id.activityMain2TvMiFirstTest))
            .check(matches(withText("Reset")))
    }

    @Test
    fun ensureChangeEditTextWorkTest() {
        onView(withId(R.id.activityMain2EtMiFirstEditText))
            .perform(typeText("Test"), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.activityMain2btChange))
            .perform(click())

        onView(withId(R.id.activityMain2TvMiFirstTest))
            .check(matches(withText("Test")))
    }

    @Test
    fun isDisplayedOnTheScreenErrorTest() {
        onView(withText("Does not show"))
            .check(matches(isDisplayed()))
    }
}
