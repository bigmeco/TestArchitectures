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

var amount: MutableState<String>? = null

class MainActivity : AppCompatActivity(), IViewState {
    val intent: IEvent = Intent()
    private var activity: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.eventState(Event.Init)

        setContent {
            amount = state { activity ?: "" }
            MaterialTheme {
                Greeting(amount!!.value, intent)
                Log.d("ПридуматьTeg", "response.body()?.activity")
            }
        }

    }

    override fun render(state: ViewState) {
        // Не вижу в этом смысла когда можно передать state
        when (state) {
            is ViewState.InitState -> {
                Log.d("ПридуматьTeg", "LoadingState")

            }
            is ViewState.LoadedState -> {
                Log.d("ПридуматьTeg", "LoadedState")

            }
            is ViewState.ErrorState -> {
                Log.d("ПридуматьTeg", "ErrorState")

            }
            is ViewState.NoItemState -> {
                Log.d("ПридуматьTeg", "NoItemState")

            }
        }
    }


}

@Composable
fun Greeting(name: String, intent: IEvent) {
    Column {
        Text(text = "Hello $name!")
        Button(onClick = {
            intent.eventState(Event.Click(amount!!))
        },
            text = { Text(text = "Загрузить") })
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        // Greeting("Android",intent = Event())
    }
}