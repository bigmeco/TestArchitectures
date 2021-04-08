package com.bigmeco.mvvmtest

import androidx.lifecycle.LiveData

class TestLiveDate : LiveData<String>() {

    fun setValueLD(string: String){
        value = string
    }

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}