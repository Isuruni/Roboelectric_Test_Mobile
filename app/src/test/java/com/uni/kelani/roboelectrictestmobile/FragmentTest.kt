package com.uni.kelani.roboelectrictestmobile

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class FragmentTest {

    private var activity: MainActivity? = null
    private var fragment: FirstFragment? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fragment = FirstFragment()
        activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(fragment!!, null)
        fragmentTransaction.commit()
    }

    @Test
    fun test_fragment_textView(){

        val textView : TextView = activity!!.findViewById(R.id.textViewFirst)

        Assert.assertEquals("Fragment Text \\n Robolectric Test", textView.text)
    }
}