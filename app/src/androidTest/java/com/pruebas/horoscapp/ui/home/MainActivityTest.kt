package com.pruebas.horoscapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pruebas.horoscapp.R
import com.pruebas.horoscapp.ui.detail.HoroscopeDetailActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0) //La primera regla tiene que ser la de HILT
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun when_mainactivity_is_created_then_open_luck_fragment() {
        onView(withId(R.id.luckFragment)).perform(click())

    }

    @Test
    fun when_horoscope_is_selected_then_open_detail() {

        onView(withId(R.id.rvHoroscope)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        Intents.intended(hasComponent(HoroscopeDetailActivity::class.java.name))
    }
}