package com.bigmeco.dagger2test.DI.components

import com.bigmeco.dagger2test.DI.module.AppModule
import com.bigmeco.dagger2test.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component (modules = [AppModule::class])
@Singleton
interface AppComponent {
fun inject(mainActivity: MainActivity)

}