package com.bigmeco.dagger2test

interface IRest {
    fun loadingData(respons: (String) -> Unit)
}