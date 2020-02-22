package com.gojek.trendingrepos.helpers

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import org.hamcrest.Matcher

object RecyclerChildView {

    fun clickChildViewWithId(id: Int, isLongClick: Boolean = false): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController?, view: View) {
                val v: View = view.findViewById(id)
                if (isLongClick) v.performLongClick() else v.performClick()
            }
        }
    }
}