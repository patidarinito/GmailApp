package com.himanshu.gmailapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class mails(
    val image: Int,
    val sender: String,
    val header: String,
    val description: String,
    val hasButton: Boolean,
    val time: String
)

val listOfMails = listOf<mails>(
    mails(R.drawable.image2,"Social", "Facebook Birthdays, Facebook...", "Wish your friends and family members...", false, "Aug 12"),
    mails(R.drawable.image2,"Glow", "Have you heard about Glow wish...", "Create your Glow WishList and share...", false, "Oct 14"),
    mails(R.drawable.first_page,"Promotions", "SendBird daniel form random House...", "", false, "Jan 14"),
    mails(R.drawable.image2,"Google", "Google has your all the data...", "Don't worry your data is of zero value...", false, "Feb 23"),
    mails(R.drawable.second_page,"PhonePe", "You have an invite from Rachid Shukla, Volunteer...", "We are employees of phonePe community...", false, "May 11"),
    mails(R.drawable.image2,"me", "Files uploaded successfully", "You can now view your photos and files...", false, "Mar 30"),
    mails(R.drawable.image2,"Paytm", "Transaction was successfully failed!", "Transaction failed successfully", false, "Jan 7"),
    mails(R.drawable.first_page,"LinkedIn", "Himanshu, you're on a roll on LinkedIn!...", "Check out these interesting conversations...", false, "Jul 24"),
    mails(R.drawable.image2,"Social", "Facebook Birthdays, Facebook...", "Wish your friends and family members...", false, "Aug 12"),
    mails(R.drawable.first_page,"Glow", "Have you heard about Glow wish...", "Create your Glow WishList and share...", false, "Oct 14"),
    mails(R.drawable.first_page,"Promotions", "SendBird daniel form random House...", "", false, "Jan 14"),
    mails(R.drawable.first_page,"Google", "Google has your all the data...", "Don't worry your data is of zero value...", false, "Feb 23"),
    mails(R.drawable.first_page,"PhonePe", "You have an invite from Rachid Shukla, Volunteer...", "We are employees of phonePe community...", false, "May 11"),
    mails(R.drawable.first_page,"me", "Files uploaded successfully", "You can now view your photos and files...", false, "Mar 30"),
    mails(R.drawable.first_page,"Paytm", "Transaction was successfully failed!", "Transaction failed successfully", false, "Jan 7"),
    mails(R.drawable.first_page,"LinkedIn", "Himanshu, you're on a roll on LinkedIn!...", "Check out these interesting conversations...", false, "Jul 24")


)

@Composable
fun MailScreen(){
    Box(){
        Column(
            modifier = Modifier
                .padding(),
            verticalArrangement = Arrangement.Top
        ) {
            LazyColumn{
                items(listOfMails) { mail ->
                    MailCard(mail)
                }
            }
        }
        // Implementation of card
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarMail(
    onNavigationClick: () -> Unit
){
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    val drawerState = remember { mutableStateOf(false) }
    Box(
        Modifier
            .fillMaxWidth()
            .semantics { isTraversalGroup = true }) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = -1f },
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = { Text("Search in mail") },
            leadingIcon = { Icon(
                imageVector = Icons.Default.Menu,
                modifier  = Modifier
                    .clickable(
                        onClick = { onNavigationClick()}
                    ),

                contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
        ) {

        }

    }
}

@Composable
fun MailCard(mail: mails){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 10.dp, bottom = 10.dp, end = 16.dp)
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = mail.image),
            modifier = Modifier
                .padding(5.dp)
                .clip(CircleShape)
                .width(40.dp)
                .height(40.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .width(320.dp)
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = mail.sender,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = mail.time,
                    fontSize = 10.sp
                )
            }
            Text(
                text = mail.header,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = mail.description,
                fontSize = 12.sp
            )
        }
    }
}
@Preview
@Composable
fun akdnasd(){
    MailScreen()
}