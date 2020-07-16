package com.bigmeco.dagger2test

import android.content.Context
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Rest (var url: String, var retrofit: Retrofit):IRest {



    override fun loadingData(respons: (String) -> Unit) {


        val service = retrofit.create(Data::class.java)
        service.search().enqueue(object : Callback<Repo> {


            override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                respons.invoke(response.body()?.activity.toString())
                Log.d("ПридуматьTeg", response.body()?.activity)
            }

            override fun onFailure(call: Call<Repo>, t: Throwable) {
                Log.d("ПридуматьTeg", "tt " + t.message)

            }
        })
        return
    }


}