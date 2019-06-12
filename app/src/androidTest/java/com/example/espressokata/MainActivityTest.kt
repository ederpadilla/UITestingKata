package com.example.espressokata

import android.app.Activity
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.StringStartsWith.startsWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mainActivityActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun helloWorldOfEspressoTest() {
        //View Matcher
        onView(withId(R.id.mTvMain))
        onView(withText("Hello Espresso!"))
        onView(withContentDescription("element tv"))
        onView(withHint("hint text"))
        onView(allOf(withText("Hello Espresso!"), withParent(withId(R.id.mainActivityParent))))
        onView(allOf(withId(R.id.mTvMain), isDisplayed()))
        onView(withText(startsWith("Hello")))
        onView(allOf(instanceOf<Any>(TextView::class.java), withId(R.id.mTvMain)))


        //View Action

        onView(withId(R.id.mEtMain))
            .perform(typeText("30"))

        onView(withId(R.id.mEtMain))
            .perform(replaceText("34"))

        onView(withId(R.id.mEtMain))
            .perform(clearText())

        //onView(withId(R.id.mBtnMain))
        //    .perform(click())

        onView(withId(R.id.mainActivityParent))
            .perform(swipeLeft())

        onView(withId(R.id.mEtMain))
            .perform(typeText("34"), ViewActions.closeSoftKeyboard())

        //onView(withId(R.id.mTvMain))
        //    .perform(openLinkWithText("www.google.es"))

        //View Assertions

        onView(withId(R.id.mTvMain))
            .check(matches(isDisplayed()))

        onView(withId(R.id.mTvMain))
            .check(matches(withText("Hello Espresso!")))

        //onView(withId(R.id.mTvMain))
        //    .check(matches(withText(R.string.app_name)))

        onView(withId(R.id.mTvMain))
            .check(isCompletelyAbove(withId(R.id.mEtMain)))

        //onView(withId(R.id.mTvMain))
        //    .check(doesNotExist())


    }
}
