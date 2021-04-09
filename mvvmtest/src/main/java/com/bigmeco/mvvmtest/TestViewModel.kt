package com.bigmeco.mvvmtest

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

//class TestViewModel : ViewModel() {
//class TestViewModel(application: Application) : AndroidViewModel(application) {
class TestViewModel(application: Application,val text: String) : AndroidViewModel(application) {

    val liveDate = MutableLiveData<String>()

    init {
        startRandom()
    }

    private fun startRandom() {
        object :CountDownTimer(20000, 1000){
            override fun onFinish() {
                Toast.makeText(getApplication(), text, Toast.LENGTH_LONG).show()
            }

            override fun onTick(millisUntilFinished: Long) {
                liveDate.value = (millisUntilFinished/1000).toString()
            }

        }.start()

    }
}