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
        Log.d("tedfgdfgfgst", "response.body()?.activity")


        setContent {
            amount = state { activity ?: "" }

            MaterialTheme {
                Greeting(amount!!.value, intent)
                Log.d("tedfgdfgfgst", "response.body()?.activity")
            }
        }

//        GlobalScope.launch(Dispatchers.Main) {

//        }


    }

    override fun render(state: ViewState) {
        // Не вижу в этом смысла когда можно передать state
        when (state) {
            is ViewState.InitState -> {
                Log.d("tedfgdfgfgst", "LoadingState")

            }
            is ViewState.LoadedState -> {
                Log.d("tedfgdfgfgst", "LoadedState")

            }
            is ViewState.ErrorState -> {
                Log.d("tedfgdfgfgst", "ErrorState")

            }
            is ViewState.NoItemState -> {
                Log.d("tedfgdfgfgst", "NoItemState")

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