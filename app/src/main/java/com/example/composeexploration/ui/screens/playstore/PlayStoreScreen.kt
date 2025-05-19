package com.example.composeexploration.ui.screens.playstore

import android.graphics.Color
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.composeexploration.R
import com.example.composeexploration.data.enums.Destination
import com.example.composeexploration.ui.theme.ComposeExplorationTheme

@Composable
fun PlayStoreScreen() {
    Scaffold (
        topBar = { AppTopBar() },
        bottomBar = { BottomNavBar() }
    ) { paddingValues ->
        ContentTabs(paddingValues)

    }
}

@Composable
fun AppTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_playstore_logo),
            contentDescription = "App Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .clip(RectangleShape)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            NotificationIcon()
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "See Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Composable
fun NotificationIcon() {
    Box {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "See Notifications",
            modifier = Modifier
                .size(30.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.error,
                    CircleShape
                )
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(3.dp),
                text = "10",
                style = TextStyle(
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.surfaceContainer
                )
            )
        }
    }
}

@Composable
fun BottomNavBar() {
    BottomAppBar (
        actions = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column (
                    modifier = Modifier.clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_game_console),
                        contentDescription = "Games",
                    )
                    Text(text = "Games")
                }
                Column (
                    modifier = Modifier.clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_apps),
                        contentDescription = "Apps"
                    )
                    Text(text = "Apps")
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "Search"
                    )
                    Text(text = "Search")
                }
                Column (
                    modifier = Modifier.clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_offers),
                        contentDescription = "Offers"
                    )
                    Text(text = "Offers")
                }
                Column (
                    modifier = Modifier.clickable {},
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_books),
                        contentDescription = "Books"
                    )
                    Text(text = "Books")
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentTabs(
    paddingValues: PaddingValues
) {
    val navController = rememberNavController()
    val startDestination = Destination.FOR_YOU
    val selectedDestination = rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    PrimaryTabRow(selectedTabIndex = selectedDestination.intValue, modifier = Modifier.padding(paddingValues)) {
        Destination.entries.forEachIndexed { index, destination ->
            val selectedTabFontWeight by remember {
                mutableStateOf(
                    if (selectedDestination.intValue == index)
                        FontWeight.Bold
                    else
                        FontWeight.Normal
                )
            }

            Tab(
                selected = selectedDestination.intValue == index,
                onClick = {
                    navController.navigate(route = destination.route)
                    selectedDestination.intValue = index
                },
                text = {
                    Text(
                        text = destination.label,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = selectedTabFontWeight
                        )
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview
@Composable
fun PreviewPlayStoreScreen() {
    ComposeExplorationTheme {
        PlayStoreScreen()
    }
}