package com.bigmeco.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    val testLiveDate = TestLiveDate()
    lateinit var observer: Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        observer = Observer {
            textView.text = it
        }
        button.setOnClickListener {
            testLiveDate.setValueLD(editText.text.toString())
        }

    }

    override fun onStart() {
        testLiveDate.observe(this, observer)
        super.onStart()
    }

    override fun onStop() {
        testLiveDate.removeObserver(observer)
        super.onStop()
    }
}