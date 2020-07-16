package com.bigmeco.dagger2test

import android.app.Application
import com.bigmeco.dagger2test.DI.components.AppComponent
import com.bigmeco.dagger2test.DI.components.DaggerAppComponent
import com.bigmeco.dagger2test.DI.module.AppModule
import javax.inject.Inject

class App : Application() {
    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule("https://www.boredapi.com/api/")).build()
    }

}