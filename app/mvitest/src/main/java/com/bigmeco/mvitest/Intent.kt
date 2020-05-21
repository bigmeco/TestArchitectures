package com.bigmeco.mvitest

import android.util.Log

class Intent : IEvent {

    val rest = Rest()

    override fun eventState(event: Event) {
        when (event) {
            is Event.Init -> {
                Log.d("tedfgdfgfgst", "Fetch")
                rest.render(Logic.Init)
                val viewState: IViewState = MainActivity()
                viewState.render(ViewState.InitState)

            }
            is Event.Click -> {
                rest.render(Logic.LoadingData(amount = amount!!))
            }

        }
    }


}