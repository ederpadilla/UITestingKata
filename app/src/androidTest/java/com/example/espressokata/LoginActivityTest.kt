package com.example.espressokata

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not

@RunWith(AndroidJUnit4::class)
class LoginActivityTest{

    //@get:Rule
    //var activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun errorMessageIsNotShowInitiallyTest() {
        onView(withId(R.id.loginActivityTvError))
            .check(matches(not(isDisplayed())))
    }

    @get:Rule
    var activityRule = IntentsTestRule(LoginActivity::class.java)


    @Test
    fun hintIsDisplayedInEditTextUserNameTest() {
        onView(withId(R.id.loginActivityEtUserName))
            .check(matches(withHint(R.string.login_activity_username_hint)))
    }

    @Test
    fun hintIsDisplayedInEditTextPasswordTest() {
        onView(withId(R.id.loginActivityEtPassword))
            .check(matches(withHint(R.string.login_activity_password_hint)))
    }

    @Test
    fun userNameLenghRuleErrorTest() {
        onView(withId(R.id.loginActivityEtUserName))
            .perform(typeText("alb"), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.loginActivityBtLogin))
            .perform(click())

        onView(withId(R.id.loginActivityTvError))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.login_activity_username_error)))
    }

    @Test
    fun passwordLenghRuleErrorTest() {

        onView(withId(R.id.loginActivityEtUserName))
            .perform(typeText("alberto"))

        onView(withId(R.id.loginActivityEtPassword))
            .perform(typeText("123"))

        onView(withId(R.id.loginActivityBtLogin))
            .perform(click())

        onView(withId(R.id.loginActivityTvError))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.login_activity_password_error)))
    }

    @Test
    fun validUserNameAndPasswordNotShowErrorMessageTest() {
        onView(withId(R.id.loginActivityEtUserName))
            .perform(typeText("alberto"))

        onView(withId(R.id.loginActivityEtPassword))
            .perform(typeText("1234"))

        onView(withId(R.id.loginActivityBtLogin))
            .perform(click())

        onView(withId(R.id.loginActivityTvError))
            .check(matches(not(isDisplayed())))

    }

    @Test
    fun validUserNameAndPasswordGoToRecyclerViewActivityTest() {
        onView(withId(R.id.loginActivityEtUserName))
            .perform(typeText("Eder"))

        onView(withId(R.id.loginActivityEtPassword))
            .perform(typeText("1234"))

        onView(withId(R.id.loginActivityBtLogin))
            .perform(click())

        //intended(hasComponent(RecyclerViewActivity::class.java.name))
        //intended(hasExtra<String>("USER", "Eder"))

        intended(
            allOf<Intent>(
                hasComponent(RecyclerViewActivity::class.java.name),
                hasExtra<String>("USER", "Eder")
            )
        )
    }

}