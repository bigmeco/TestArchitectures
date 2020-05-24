package com.bigmeco.mvitest

import androidx.compose.MutableState

sealed class ViewState {
    object InitState : ViewState()
    object NoItemState : ViewState()
    class LoadedState(val item: Repo) : ViewState()
    class ErrorState(val error: String) : ViewState()


}

sealed class Event {
    object Init : Event()
    class ClickMutableState(var amount: MutableState<String>) : Event()
    class ClickSealedClass(var viewState: IViewState) : Event()
}

sealed class Logic {
    object Init : Logic()
    class LoadingData(var amount: MutableState<String>) : Logic()
    class LoadingDataSealed(var viewState: IViewState) : Logic()
}