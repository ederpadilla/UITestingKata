package com.example.espressokata

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.espressokata.util.ExpressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IdlingActivityTest{


    @get:Rule
    var activityRule = IntentsTestRule(IdlingActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(
            ExpressoIdlingResource.idlingResource
        )
    }

    @Test
    fun textIsDisplayedAfterWebServiceTest() {

        onView(withId(R.id.idlingActivityBt))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.idlingActivityTv))
            .check(matches(isDisplayed()))
            .check(matches(withText("Eder")))
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(
            ExpressoIdlingResource.idlingResource
        )
    }
}