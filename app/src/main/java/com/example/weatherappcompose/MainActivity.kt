package com.example.weatherappcompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherappcompose.screens.MainCard
import com.example.weatherappcompose.screens.TabLayout
import com.example.weatherappcompose.ui.theme.WeatherAppComposeTheme
import org.json.JSONObject


const val API_KEY = "8495b5b4600c43d1987184601231605"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
                    Image(
                        painter = painterResource(id = R.drawable.weather_bg), contentDescription = "img1",
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.9f),
                        contentScale = ContentScale.FillBounds
                    )

                    Column {
                        MainCard()
                        TabLayout()
                    }

//                    Greeting("Minsk",this)

            }
        }
    }
}

@Composable
fun Greeting(name: String, context: Context) {
    val state = remember{
        mutableStateOf("Unknown")
    }

    Column(modifier = Modifier
            .fillMaxSize())
    {
        Box(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Text(text = "Temperature in $name = ${state.value} °C")
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){

            Button(onClick =
            {
                getResult(name,state, context)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                Text(text = "Refresh")

            }
        }

    }

}

fun getResult(city: String, state : MutableState<String>, context: Context){

    val url = "http://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&" +
            "q=$city" +
            "&aqi=no"

    val queue = Volley.newRequestQueue(context)

    val stringRequest = StringRequest(
        com.android.volley.Request.Method.GET,
        url,
        {
            response->
            val obj = JSONObject(response)
            state.value = obj.getJSONObject("current").getString("temp_c")
        },
        {
            error->
            Log.d("myLog","error = $error")

        }
    )

    queue.add(stringRequest)
}

