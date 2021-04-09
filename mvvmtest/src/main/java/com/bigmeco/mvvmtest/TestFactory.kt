package com.bigmeco.mvvmtest

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TestFactory(val application: Application, val text: String) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestViewModel(application, text) as T
    }
}