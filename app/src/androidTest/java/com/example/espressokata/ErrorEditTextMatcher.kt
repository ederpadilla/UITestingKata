package com.example.espressokata

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object ErrorEditTextMatcher {

    fun withError(stringMatcher: Matcher<String>): Matcher<View> {
        return object : BoundedMatcher<View, EditText>(EditText::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("Error text: ")
                stringMatcher.describeTo(description)
            }

            override fun matchesSafely(editText: EditText): Boolean {
                return stringMatcher.matches(editText.error.toString())
            }
        }
    }
}
