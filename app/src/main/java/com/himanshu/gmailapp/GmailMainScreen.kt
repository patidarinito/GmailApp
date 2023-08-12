package com.himanshu.gmailapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

sealed class BottomScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){ object Mail: BottomScreen(
        route = "Mail",
        title = "Mails",
        icon = Icons.Default.Email
    )object Call: BottomScreen(
        route = "Call",
        title = "Calls",
        icon = Icons.Default.Settings
    )
}
val items = listOf(
    BottomScreen.Mail,
    BottomScreen.Call
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    var scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if(currentRoute?.route == BottomScreen.Mail.route) SearchBarMail{
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
            else MeetTopBar{
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }

        },
        drawerContent = {
            NavigationDrawerHeading()
            NavigationDrawerSubHeading()

        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
            ) {
                items.forEach{ item->
                    BottomNavigationItem(
                        selectedContentColor = Color.Black,
                        label = {Text(text = item.title)},
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = "Navigation icon"
                            )
                        },
                        selected = currentRoute?.route == item.route,
                        onClick = {
                            navController.navigate(item.route) {

                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },

                        )
                }
            }

        }

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = BottomScreen.Mail.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = BottomScreen.Mail.route,){
                MailScreen()
            }
            composable(route = BottomScreen.Call.route){
                VideoCallScreen()
            }
        }

    }
}
@Preview
@Composable
fun GmailMainPreview(){
    MainScreen()
}