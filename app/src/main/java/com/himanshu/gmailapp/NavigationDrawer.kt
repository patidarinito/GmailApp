package com.himanshu.gmailapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class mailTypes(
    val icon: ImageVector,
    val header: String,
    val messages: Int
)
val listofMailTypes = listOf<mailTypes>(
    mailTypes(Icons.Default.AccountBox, "Primary", 56),
    mailTypes(Icons.Default.CheckCircle, "Promotions", 56),
    mailTypes(Icons.Default.Star, "Social", 56)
)
@Composable
fun NavigationDrawerHeading(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(20.dp)

    ) {
        Text(
            text = "Gmail",
            fontSize = 20.sp,
        )
    }
    Divider(color = Color.Black, thickness = 1.dp)
}
@Composable
fun NavigationDrawerSubHeading(){
    Column(

    ) {
        LazyColumn{
            items(listofMailTypes){item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Image(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(start = 10.dp, 5.dp),
                        text = item.header
                    )
                    Text(
                        text = item.messages.toString()
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun jkadasjkdn(){
    Column {
        NavigationDrawerHeading()
        NavigationDrawerSubHeading()
    }
}