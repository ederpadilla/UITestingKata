package com.example.espressokata

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpinnerActivityTest{
    @get:Rule
    var activityRule = IntentsTestRule(SpinnerActivity::class.java)


    @Test
    fun spinnerTest() {
        onView(withId(R.id.spinnerActivitySp))
            .perform(click())

        onData(anything())
            .atPosition(1)
            .perform(click())

        onView(withId(R.id.spinnerActivitySp))
            .check(matches(withSpinnerText(containsString("Manuel"))))
    }

    @Test
    fun spinnerTest2() {
        onView(withId(R.id.spinnerActivitySp))
            .perform(click())

        onData(
            allOf<String>(
                `is`<Any>(instanceOf<Any>(String::class.java)),
                `is`<String>("Pablo")
            )
        )
            .perform(click())

        onView(withId(R.id.spinnerActivityTv))
            .check(matches(withText("Pablo")))
    }
}