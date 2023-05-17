package com.example.weatherappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.ui.theme.SkyBlue


@Preview(showBackground = true)
@Composable
fun MainCard() {
    Image(
        painter = painterResource(id = R.drawable.weather_bg), contentDescription = "img1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 100.dp,
            backgroundColor = SkyBlue,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "17.05.2023 0:27",
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                        color = Color.White,
                        style = TextStyle(fontSize = 15.sp)
                    )
                    AsyncImage(
                        model = "https://cdn.weatherapi.com/weather/64x64/night/116.png",
                        contentDescription = "img2",
                        modifier = Modifier
                            .padding(top = 3.dp, end = 5.dp)
                            .size(30.dp)
                    )

                }

                Text(
                    text = "Minsk", color = Color.White,
                    style = TextStyle(fontSize = 25.sp)
                )


                Text(
                    text = "24°C", color = Color.White,
                    style = TextStyle(fontSize = 70.sp)
                )

                Text(
                    text = "Sunny", color = Color.White,
                    style = TextStyle(fontSize = 25.sp)
                )


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    IconButton(onClick = {

                    }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "img3",
                            tint = Color.White
                        )


                    }

                    Text(
                        text = "15°C/14°C", color = Color.White,
                        style = TextStyle(fontSize = 15.sp)
                    )


                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sync),
                            contentDescription = "img4",
                            tint = Color.White
                        )

                    }


                }


            }

        }


    }

}