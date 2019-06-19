package com.example.espressokata

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.espressokata.ErrorEditTextMatcher.withError
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CustomMatcherActivityTest{

    @get:Rule
    var activityRule = IntentsTestRule(CustomMatcherActivity::class.java)

    @Test
    fun checkWithWrongUserNameTest() {
        onView(withId(R.id.customMatcherActivityEtUserName))
            .perform(typeText("al"))

        onView(withId(R.id.customMatcherActivityBtLogin))
            .perform(click())

        onView(withId(R.id.customMatcherActivityEtUserName))
            .check(
                matches(
                    withError(
                        Matchers.containsString(activityRule.activity.getString(R.string.login_activity_username_error))
                    )
                )
            )
    }

    @Test
    fun checkWithWrongPasswordTest() {
        onView(withId(R.id.customMatcherActivityEtUserName))
            .perform(typeText("eder"))

        onView(withId(R.id.customMatcherActivityEtPassword))
            .perform(typeText("123"))

        onView(withId(R.id.customMatcherActivityBtLogin))
            .perform(click())

        onView(withId(R.id.customMatcherActivityEtPassword))
            .check(
                matches(
                    withError(
                        Matchers.containsString(activityRule.activity.getString(R.string.login_activity_password_error))
                    )
                )
            )
    }

    @Test
    fun validUserNameAndPasswordGoToSpinnerActivityTest() {
        onView(withId(R.id.customMatcherActivityEtUserName))
            .perform(typeText("Eder"))

        onView(withId(R.id.customMatcherActivityEtPassword))
            .perform(typeText("1234"))

        onView(withId(R.id.customMatcherActivityBtLogin))
            .perform(click())

        intended(hasComponent(SpinnerActivity::class.java.name))
    }


}