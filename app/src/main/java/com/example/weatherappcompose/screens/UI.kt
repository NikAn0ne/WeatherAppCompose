package com.example.weatherappcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.ui.theme.SkyBlue

@Preview(showBackground = true)
@Composable
fun ListItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        backgroundColor = SkyBlue,
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier) {
                Text(text = "14:38", modifier = Modifier.padding(start = 5.dp))
                Text(
                    text = "Sunny",
                    modifier = Modifier.padding(start = 5.dp),
                    color = Color.White
                )

            }
            Text(
                text = "26°C",
                color = Color.White,
                style = TextStyle(fontSize = 30.sp)
            )

            AsyncImage(
                model = "https://cdn.weatherapi.com/weather/64x64/night/116.png",
                contentDescription = "img2",
                modifier = Modifier
                    .padding(top = 3.dp, end = 5.dp)
                    .size(30.dp)
            )

        }

    }

}