package com.uni.kelani.roboelectrictestmobile

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {


    @Test
    fun test_activity_textView() {

        val activity = Robolectric.buildActivity(SecondActivity::class.java).create().get()
        val textView : TextView = activity.findViewById<TextView>(R.id.textViewActivity)

        assertEquals("Activity Text \\n Robolectric Test", textView.text)
    }

    @Test
    fun test_fragment_textView(){

        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.textViewFirst)

        assertEquals("Fragment Text \\n Robolectric Test", textView.text)
    }

}