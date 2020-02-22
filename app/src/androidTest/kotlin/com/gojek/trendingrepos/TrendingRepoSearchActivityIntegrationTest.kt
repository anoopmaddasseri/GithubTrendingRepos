package com.gojek.trendingrepos

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepoSearchActivity
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepoSearchResultAdapter
import com.gojek.trendingrepos.helpers.RecyclerChildView
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class TrendingRepoSearchActivityIntegrationTest : BaseTest() {

    private lateinit var appContext: Context

    @get:Rule
    var activityRule: ActivityTestRule<TrendingRepoSearchActivity> =
        ActivityTestRule(TrendingRepoSearchActivity::class.java, false, false)

    @get:Rule
    val intentsTestRule = IntentsTestRule(TrendingRepoSearchActivity::class.java)

    @Before
    override fun setup() {
        super.setup()
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent()
        activityRule.launchActivity(intent)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.gojek.trendingrepos", appContext.packageName)
    }

    @Test
    fun checkToolbarTitle() {
        onView(withId(R.id.toolbarTitle)).check(matches(withText(R.string.title_trending)))
    }

    @Test
    fun performRepoItemClick() {
        clickRepoItem(0)
        sleep()
        clickRepoItem(1)
        sleep()
    }

    @Test
    fun performRepoItemLonClick() {
        clickRepoItem(0, true)
        sleep()
    }

    @Test
    fun performScrolling() {
        // First, scroll to the view holder using the isInTheMiddle() matcher.
        onView(withId(R.id.rvRepository))
            .perform(
                RecyclerViewActions.scrollToPosition<TrendingRepoSearchResultAdapter.TrendingRepoViewHolder>(
                    10
                )
            )
        sleep()
    }

    private fun clickRepoItem(position: Int, isLongClick: Boolean = false) {
        onView(withId(R.id.rvRepository)).perform(
            RecyclerViewActions.actionOnItemAtPosition<TrendingRepoSearchResultAdapter.TrendingRepoViewHolder>(
                position,
                RecyclerChildView.clickChildViewWithId(R.id.containerTrendingRepo, isLongClick)
            )
        )
    }

    @Test
    fun sortRepositoriesByName() {
        openActionBarOverflowOrOptionsMenu(appContext)
        onView(withText(R.string.label_sort_by_name)).perform(click())
        sleep()
        clickRepoItem(0)
        sleep()
    }

    @Test
    fun sortRepositoriesByStars() {
        openActionBarOverflowOrOptionsMenu(appContext)
        onView(withText(R.string.label_sort_by_stars)).perform(click())
        sleep()
        clickRepoItem(0)
        sleep()
    }

    @Test
    fun shouldDisplayRecyclerView() {
        onView(withId(R.id.rvRepository))
            .check(matches(withChild(isDisplayed())))
    }

    @Test
    fun shouldDisplayErrorView() {
        sleep()
        onView(withId(R.id.vInvisible)).perform(click())
        sleep()
        //Hides alert dialog
        onView(withText(appContext.getString(R.string.error_offline_test_scenario))).perform(
            pressBack()
        )
        onView(withId(R.id.swipeRepoRefresh))
            .perform(withCustomConstraints(swipeDown(), isDisplayingAtLeast(85)))
        sleep()
    }

    @Test
    fun forceRefreshRepositories() {
        onView(withId(R.id.swipeRepoRefresh))
            .perform(withCustomConstraints(swipeDown(), isDisplayingAtLeast(85)))
        sleep()
    }

    private fun withCustomConstraints(
        action: ViewAction, constraints: Matcher<View?>?
    ): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View?>? {
                return constraints
            }

            override fun getDescription(): String? {
                return action.description
            }

            override fun perform(
                uiController: UiController?,
                view: View?
            ) {
                action.perform(uiController, view)
            }
        }
    }

    @After
    override fun tearDown() {
        super.tearDown()
        activityRule.finishActivity()
    }

}