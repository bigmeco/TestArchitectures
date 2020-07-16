package com.bigmeco.mvitest

import androidx.compose.MutableState


// результат запроса во view (реализация на view)
sealed class ViewState {
    object InitState : ViewState()
    object NoItemState : ViewState()
    class LoadedState(val item: Repo) : ViewState()
    class ErrorState(val error: String) : ViewState()


}
// события с view в intent (реализация на Activity event)

sealed class Event {
    object Init : Event()
    class ClickMutableState(var amount: MutableState<String>) : Event()
    class ClickSealedClass(var viewState: IViewState) : Event()
}

// запрос к model за датай (реализация на model)
sealed class Logic {
    object Init : Logic()
    class LoadingData(var amount: MutableState<String>) : Logic()
    class LoadingDataSealed(var viewState: IViewState) : Logic()
}