package com.example.composeexploration.ui.screens.playstore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexploration.R
import com.example.composeexploration.data.playstore.CarouselItem
import kotlinx.coroutines.delay

val carouselItems: List<CarouselItem> = listOf(
    CarouselItem(
        id = 0,
        imageResId = R.drawable.sunset,
        contentDescription = "Item 1",
        title = "New apps we love",
        description = "See our latest picks",
        additionalDesc = "From the editors"
    ),
    CarouselItem(
        id = 1,
        imageResId = R.drawable.sunset2,
        contentDescription = "Item 2",
        title = "Dive into the exciting world of Short Drama",
        description = "Apps to stream this summer"
    ),
    CarouselItem(
        id = 2,
        imageResId = R.drawable.sunset3,
        contentDescription = "Item 3",
        title = "Fantastic Journey",
        additionalDesc = "Ends in 6 days",
        appName = "Duolingo: Language Lessons",
        appCompany = "Duolingo",
        appRating = "4.8",
        appAgeRestriction = "3+",
        isAppItem = true
    ),
    CarouselItem(
        id = 3,
        imageResId = R.drawable.sunset4,
        contentDescription = "Item 4",
        title = "Try Adobe Express Premium plan free for 14 days",
        appName = "Adobe Express: AI Photo, Video",
        appCompany = "Adobe",
        appRating = "4.7",
        appAgeRestriction = "3+",
        isAppItem = true
    ),
)

@Composable
fun ForYouScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BannersCarousel(itemsCount = carouselItems.size)
        }
        item {
            SuggestedFypTitle() 
        }
    }
}

@Composable
fun BannersCarousel(
    autoSlideDuration: Long = 200,
    itemsCount: Int,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { itemsCount })
    
    LaunchedEffect(key1 = pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage+1) % itemsCount)
    }

    HorizontalPager(state = pagerState) { page ->
        BannerItem(page)
    }
}

@Composable
fun BannerItem(index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(id = carouselItems[index].imageResId),
            contentDescription = carouselItems[index].contentDescription,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun SuggestedFypTitle() {
    Row (
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Sponsored",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Box(modifier = Modifier
                .width(5.dp)
                .height(5.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
            )
            Text(
                text = "Suggested For You",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "More"
            )
        }
    }
}