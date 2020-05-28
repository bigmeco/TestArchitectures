package com.bigmeco.dagger2test.DI.module

import com.bigmeco.dagger2test.IRest
import com.bigmeco.dagger2test.Rest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class AppModule(var url: String) {

    @Provides
    @Singleton
   fun provideUrl(): String {
        return url
    }
    @Provides
    @Singleton
    fun provideIRest(retrofit: Retrofit):IRest = Rest(url = url, retrofit = retrofit)


}