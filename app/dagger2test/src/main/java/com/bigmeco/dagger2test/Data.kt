package com.bigmeco.dagger2test

import retrofit2.Call
import retrofit2.http.GET
import java.util.*


interface Data {
        @GET("activity")
        fun search(): Call<Repo>
}
