package com.example.weatherappcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherappcompose.R
import com.example.weatherappcompose.data.WeatherModel
import com.example.weatherappcompose.ui.theme.SkyBlue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@Composable
fun MainCard(currentDay: MutableState<WeatherModel>) {

    Column(
        modifier = Modifier
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
                        text = currentDay.value.time,
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                        color = Color.White,
                        style = TextStyle(fontSize = 15.sp)
                    )
                    AsyncImage(
                        model = "https:${currentDay.value.icon}",
                        contentDescription = "img2",
                        modifier = Modifier
                            .padding(top = 3.dp, end = 5.dp)
                            .size(30.dp)
                    )

                }

                Text(
                    text = currentDay.value.city, color = Color.White,
                    style = TextStyle(fontSize = 25.sp)
                )


                Text(
                    text = currentDay.value.currentTemp.toFloat().toInt().toString() + "°C",
                    color = Color.White,
                    style = TextStyle(fontSize = 70.sp)
                )

                Text(
                    text = currentDay.value.condition, color = Color.White,
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
                        text = "${
                            currentDay.value.maxTemp.toFloat().toInt()
                        }°C/${currentDay.value.minTemp.toFloat().toInt()}°C",
                        color = Color.White,
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


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(daysList: MutableState<List<WeatherModel>>) {
    val tabList = listOf("HOURS", "DAYS")
    val pagerState = rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {

        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { pos ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, pos)
                )
            },
            backgroundColor = SkyBlue,
            contentColor = Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(selected = false,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {

                        Text(text = text)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state = pagerState,
            modifier = Modifier.weight(1.0f)
        ) { index ->


            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(
                    daysList.value
                ) { index, item ->
                    ListItem(item)
                }

            }


        }

    }
}