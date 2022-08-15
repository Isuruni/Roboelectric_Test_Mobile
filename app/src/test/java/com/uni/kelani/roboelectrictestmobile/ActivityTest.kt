package com.uni.kelani.roboelectrictestmobile

import android.widget.TextView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ActivityTest {

    private var activity: SecondActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(SecondActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun test_activity_textView() {

        val activity = Robolectric.buildActivity(SecondActivity::class.java).create().get()
        val textView : TextView = activity.findViewById(R.id.textViewActivity)

        Assert.assertEquals("Activity Text \\n Robolectric Test", textView.text)
    }

}