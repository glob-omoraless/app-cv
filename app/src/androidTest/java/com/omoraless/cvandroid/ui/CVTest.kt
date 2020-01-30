package com.omoraless.cvandroid.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.omoraless.cvandroid.model.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class CVTest {
    lateinit var cv : CV
    lateinit var language : MutableList<Language>

    @Before
    fun setupBeforeTest(){
        cv = getFakeCV()
        language = getFakeLanguage()
    }

    private fun getFakeLanguage(): MutableList<Language> {
        val language1 = Language("English", "B2")
        val language2 = Language("Spanish", "native")
        language = mutableListOf(language1, language2)
        return language

    }

    @Rule @JvmField
    var activityScenarioRule: ActivityScenarioRule<CVActivity> =
        ActivityScenarioRule<CVActivity>(
            CVActivity::class.java
        )

    @Test
    fun onLaunch_displaysAllViews() {
        onView(withId(com.omoraless.cvandroid.R.id.constraintLayout)).check(matches(isDisplayed()))
        onView(withId(com.omoraless.cvandroid.R.id.card_view_summary)).check(matches(isDisplayed()))
        onView(withId(com.omoraless.cvandroid.R.id.card_view_education)).check(matches(isDisplayed()))
        onView(withId(com.omoraless.cvandroid.R.id.card_view_recycler_v)).check(matches(isDisplayed()))
    }


    @Test
    fun cVResponsibilitiesIsCompleteOnInit(){
        cv.career_history.forEach {
            it.responsibilities != null
        }

    }

    private fun getFakeCV(): CV {
        val technologies = mutableListOf("java", "kotlin")
        val project1 = Project("https://cdn.pixabay.com/photo/2016/11/22/07/27/purdue-university-1848563_1280.jpg",
            "Travel Mate", "july 2017 -july 2018")
        val project2 = Project("https://cdn.pixabay.com/photo/2016/11/22/07/27/purdue-university-1848563_1280.jpg",
            "Travel Mate", "july 2017 -july 2018")
        val project = mutableListOf(project1, project2)
        val education = Education("Purdu", "2013 - 2018", "https://cdn.pixabay.com/photo/2016/11/22/07/27/purdue-university-1848563_1280.jpg")
        val careerHistory = CareerHistory("SoftNear", "https://cdn.pixabay.com/photo/2016/11/22/07/27/purdue-university-1848563_1280.jpg",
            "july 2017 - july 2018", "Highly concentrate on testing and improving software development and process skills in the development phase. Refactoring application(implemented Dagger 2, obfuscation and MVP",
            "Android QA", project)
        val info = Info("Karla Morales", "karla@gmail.com", "London", "5673245678",
            "https://cdn.pixabay.com/photo/2014/03/25/16/54/user-297566_1280.png",
            "Analytical and detail oriented Android app developer professional with stellar communication skills. Adept at bringing all team members together to reach a common goal on time and under budget. Conceptualizing app solutions with the latest technology, design theory, and a large dose of creativity. Committed to viable and easily functional app solutions for clients.",
            technologies, getFakeLanguage())
        val cv = CV(info, mutableListOf(careerHistory, careerHistory), education)
        return cv
    }
}