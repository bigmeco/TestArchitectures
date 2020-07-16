package com.bigmeco.mvitest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme


class Mvi2Activity : AppCompatActivity(), IViewState {
    val intent: IEvent = Intent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewState: IViewState = this

        intent.eventState(Event.Init)

        setContent {
            MaterialTheme {
                intent.eventState(Event.ClickSealedClass(viewState))
                Log.d("ПридуматьTeg", "response.body()?.activity")
            }
        }

    }

    override fun render(state: ViewState) {
        when (state) {
            is ViewState.InitState -> {
                Log.d("ПридуматьTeg", "LoadingState")
            }
            is ViewState.LoadedState -> {
                Log.d("ПридуматьTeg", state.item.activity)

            }
            is ViewState.ErrorState -> {
                Log.d("ПридуматьTeg", state.error)

            }
            is ViewState.NoItemState -> {
                Log.d("ПридуматьTeg", "NoItemState")

            }
        }
    }


}

