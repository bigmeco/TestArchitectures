package com.bigmeco.mvitest

import android.util.Log

class Intent : IEvent {

    val rest = Rest()

    override fun eventState(state: Event) {
        when (state) {
            is Event.Init -> {
                Log.d("ПридуматьTeg", "Fetch")
                rest.render(Logic.Init)
            }


            is Event.ClickMutableState -> {
                rest.render(Logic.LoadingData(amount = state.amount!!))
            }
            is Event.ClickSealedClass -> {
                rest.render(Logic.LoadingDataSealed(viewState = state.viewState!!))
            }

        }
    }


}