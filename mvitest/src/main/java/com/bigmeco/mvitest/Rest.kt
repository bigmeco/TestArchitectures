package com.bigmeco.mvitest

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rest : IRest {


    override fun render(state: Logic) {
        when (state) {
            is Logic.Init -> {

            }
            is Logic.LoadingData -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.boredapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service = retrofit.create(Data::class.java)
                service.search().enqueue(object : Callback<Repo> {


                    override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                        state.amount.value = response.body()?.activity.toString()
                        Log.d("ПридуматьTeg", response.body()?.activity)
                    }

                    override fun onFailure(call: Call<Repo>, t: Throwable) {
                        Log.d("ПридуматьTeg", "tt " + t.message)

                    }
                })
            }
            is Logic.LoadingDataSealed -> {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.boredapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service = retrofit.create(Data::class.java)
                service.search().enqueue(object : Callback<Repo> {


                    override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                        state.viewState.render(ViewState.LoadedState(response.body()!!))
                        Log.d("ПридуматьTeg", response.body()?.activity)
                    }

                    override fun onFailure(call: Call<Repo>, t: Throwable) {
                        state.viewState.render(ViewState.ErrorState(t.message.toString()))
                        Log.d("ПридуматьTeg", "tt " + t.message)

                    }
                })
            }
        }
    }

}