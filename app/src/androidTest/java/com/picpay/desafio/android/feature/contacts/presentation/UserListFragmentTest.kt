package com.picpay.desafio.android.feature.contacts.presentation

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.picpay.desafio.android.R
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserListFragmentTest {

    private lateinit var server: MockWebServer

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setup() {
        server = MockWebServer().apply {
            start(serverPort)
            url("http://localhost")
        }

        launchFragmentInContainer<UserListFragment>()
    }

    @Test
    fun shouldDisplayTitleAndLoading() {
        val expectedTitle = context.getString(R.string.title)

        onView(ViewMatchers.withText(expectedTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.user_list_progress_bar)).check(matches(isDisplayed()))
    }

//    @Test
//    fun shouldDisplayListItem() {
//        server.enqueue(MockResponse().setBody(body))
//
//        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
//    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    companion object {
        private const val serverPort = 8080

        val body =
            "[{\"id\":1001,\"name\":\"Eduardo Santos\",\"img\":\"https://randomuser.me/api/portraits/men/9.jpg\",\"username\":\"@eduardo.santos\"}]"

        private val errorResponse by lazy { MockResponse().setResponseCode(404) }
    }
}