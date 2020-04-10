package com.mvvmclean.trendingrepos

import android.os.SystemClock
import com.mvvmclean.trendingrepos.helpers.TrendingRepoRequestDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before


open class BaseTest {

    companion object {
        const val SYSTEM_ACTION_INTERVAL_TIME = 2000L
    }

    lateinit var mockWebServer: MockWebServer

    @Before
    open fun setup() {
        mockWebServer = MockWebServer().apply {
            dispatcher = TrendingRepoRequestDispatcher()
            start(8080)
        }
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }

    fun sleep() {
        SystemClock.sleep(SYSTEM_ACTION_INTERVAL_TIME)
    }
}