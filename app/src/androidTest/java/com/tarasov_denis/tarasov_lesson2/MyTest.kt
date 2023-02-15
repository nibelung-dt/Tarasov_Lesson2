package com.tarasov_denis.tarasov_lesson2

import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MyTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun listGoesOverTheFold() {
        // onView(withText("Hello world!")).check(matches(isDisplayed()))
        onView(withId(R.id.goTo)).perform(click())
    }

    @get:Rule
    val activityRule2 = ActivityScenarioRule(SecondActivity::class.java)
    @Test
    fun listGoesOverTheFold2() {
        // onView(withText("Hello world!")).check(matches(isDisplayed()))
        // onView(withId(R.id.goTo)).perform(click())
    }



    // onView(withId(R.id.goTo)).perform(click())
}


//androidTestImplementation('androidx.test:runner:1.4.0')
//androidTestImplementation('androidx.test:rules:1.4.0')