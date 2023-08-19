package com.himanshu.gmailapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MeetTopBar(
    onNavigationClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .clickable{
                    onNavigationClick()
                }
                .padding(top = 10.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = null
        )
        Text(
            text = "Meet",
            fontSize = 30.sp
        )
        Image(
            modifier = Modifier
                .padding(top = 10.dp),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null
        )
    }
}
@Composable
fun VideoCallScreen(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.40f),
                onClick = { /*TODO*/ }
            ) {
              Text(
                  text = "New meeting"
              )
            }
            OutlinedButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Join with a code"
                )
            }
        }

        HorizontalPagerCalls()


    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerCalls(
){
    val pagerState = rememberPagerState(pageCount = { 2 })
    val slideImage = remember { mutableIntStateOf(R.drawable.no_image) }
    val header = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(10.dp),
            state = pagerState,
        ) { page ->
            when(page)  {
                0 -> {
                    slideImage.value = R.drawable.first_page
                    header.value = "Get a link you can share"
                    description.value = "Tap New meeting to get a link you can send to people you want to meet with"
                }

                1 -> {
                    slideImage.value = R.drawable.second_page
                    header.value = "Your meeting is safe"
                    description.value = "No one can joi a meeting unless invited or admitted by the host"
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    //Image
                    // Head
                    // Descriptions
                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                        .padding(10.dp),
                    painter = painterResource(id = slideImage.value),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(10.dp),
                    text = header.value,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(10.dp),
                    text = description.value,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }

        }
        Spacer(modifier = Modifier.padding(4.dp))
        DotsIndicator(
            totalDots = 2,
            selectedIndex = pagerState.currentPage,
            selectedColor = Color.Gray,
            unSelectedColor = Color(0xFFE6E6E6)
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots : Int,
    selectedIndex : Int,
    selectedColor: Color,
    unSelectedColor: Color,
){

    LazyRow(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

        }
    }
}

@Preview
@Composable
fun kadnasd(){
    VideoCallScreen()
}