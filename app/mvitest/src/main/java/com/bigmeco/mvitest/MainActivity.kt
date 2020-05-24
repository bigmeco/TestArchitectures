package com.bigmeco.mvitest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.compose.MutableState
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.material.Divider
import androidx.ui.unit.dp

var amount: MutableState<String>? = null

class MainActivity : AppCompatActivity(), IViewState {
    val intent: IEvent = Intent()
    private var activity: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewState: IViewState = this
        viewState.render(ViewState.InitState)

        intent.eventState(Event.Init)

        setContent {
            amount = state { activity ?: "" }
            MaterialTheme {
                Greeting(amount!!.value, intent, viewState)
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
                amount?.value = state.item.activity
                Log.d("ПридуматьTeg", state.item.activity)

            }
            is ViewState.ErrorState -> {
                amount?.value = state.error

                Log.d("ПридуматьTeg", state.error)

            }
            is ViewState.NoItemState -> {
                Log.d("ПридуматьTeg", "NoItemState")

            }
        }
    }


}

@Composable
fun Greeting(
    name: String,
    intent: IEvent,
    viewState: IViewState
) {
    Column {
        Text(text = "Hello $name!")
        Divider(color = Color.Transparent, thickness = 32.dp)
        Button(onClick = {
            intent.eventState(Event.ClickMutableState(amount!!))
        },
            text = { Text(text = "Загрузить через MutableState") })
        Divider(color = Color.Transparent, thickness = 32.dp)

        Button(onClick = {
            intent.eventState(Event.ClickSealedClass(viewState))
        },
            text = { Text(text = "Загрузить через sealed класс") })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        // Greeting("Android",intent = Event())
    }
}