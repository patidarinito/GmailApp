package com.himanshu.gmailapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.FilledIconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.himanshu.gmailapp.room.Item

@Composable
fun ShopScreen(
    viewModal: ItemsViewModal
){
    val allItems = viewModal.allWords.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Shop",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(
                    text = "Cart",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            }
        }
        LazyColumn(

        ){
            items(allItems){
                ShoppingCard(it)
            }
        }
    }
}
@Composable
fun ShoppingCard(
    item: Item
){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                model = item.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = item.title,
                fontSize = 20.sp,
                color = Color(0xFF022725),
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$${rupeesToDollars(item.discountedPrice.toDouble(), 83.34)}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Button(
                    onClick = {

                }) {
                    Text(
                        text = "Add",
                        fontSize = 15.sp
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = item.description,
                fontSize = 17.sp,

            )
            Card(
                modifier = Modifier
                    .background(Color.LightGray)
            ) {
                Text(
                    text = item.shippingInfo,
                    Modifier.padding(10.dp),

                )
            }
        }
    }
}
fun rupeesToDollars(rupees: Double, exchangeRate: Double): Int {
    return (rupees / exchangeRate).toInt()
}