package com.bigmeco.dagger2test.DI.module

import android.content.Context
import com.bigmeco.dagger2test.IRest
import com.bigmeco.dagger2test.Rest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var url: String) {


    @Provides
    @Singleton
   fun provideUrl(): String {
        return url
    }
    @Provides
    @Singleton
    fun provideIRest():IRest = Rest(url = url)
}