package com.bigmeco.mvitest
import androidx.compose.MutableState

sealed class ViewState  {
    object InitState : ViewState()
    object NoItemState : ViewState()
    class LoadedState(val item: Repo) : ViewState()
    class ErrorState(val error: String) : ViewState()


}

sealed class Event {
    object Init : Event()
    class Click(var amount: MutableState<String>) : Event()
}
sealed class Logic {
    object Init : Logic()
    class LoadingData(var amount: MutableState<String>) : Logic()
}