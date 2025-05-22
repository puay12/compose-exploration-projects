package com.example.composeexploration.ui.screens.playstore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.composeexploration.R
import com.example.composeexploration.data.playstore.AppItem
import com.example.composeexploration.data.playstore.CarouselItem
import com.example.composeexploration.data.playstore.getDummyAppItems
import com.example.composeexploration.data.playstore.getDummyCarouselItems
import com.example.composeexploration.util.toReadableAppSize
import kotlinx.coroutines.delay

val carouselItems = getDummyCarouselItems()
val appItems = getDummyAppItems()

@Composable
fun ForYouScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BannersCarousel(itemsCount = carouselItems.size)
        }
        item {
            SuggestedFypTitle()
        }
        item {
            SuggestedForYouContent()
        }
    }
}

@Composable
fun BannersCarousel(
    autoSlideDuration: Long = 3000,
    itemsCount: Int,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { itemsCount })
    
    LaunchedEffect(key1 = pagerState.settledPage) {
        delay(autoSlideDuration)
        val nextPage = (pagerState.settledPage+1) % itemsCount
        pagerState.animateScrollToPage(nextPage)
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
        modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Sponsored",
                style = MaterialTheme.typography.labelLarge
            )
            Box(modifier = Modifier
                .width(5.dp)
                .height(5.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
            )
            Text(
                text = "Suggested For You",
                style = MaterialTheme.typography.titleLarge
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

@Composable
fun SuggestedForYouContent() {
    val grouppedItems = appItems.chunked(3)

    LazyRow (
        modifier = Modifier.fillMaxWidth()
    ) {
        items(grouppedItems) { group ->
            Column (
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.wrapContentWidth().padding(end = 24.dp)
            ) {
                group.forEach { item ->
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card (
                            modifier = Modifier.width(60.dp).height(60.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            AsyncImage(
                                model = item.imageString,
                                contentDescription = "app logo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Column (
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = item.name,
                                style = MaterialTheme.typography.titleMedium,
                            )
                            Row (
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                item.categoryList.forEachIndexed { index, category ->
                                    Text(
                                        text = category,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Gray,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    if (index < (item.categoryList.size-1)) {
                                        Box(modifier = Modifier
                                            .width(3.dp)
                                            .height(3.dp)
                                            .background(MaterialTheme.colorScheme.primary, CircleShape)
                                        )
                                    }
                                }
                            }
                            Row (verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = item.rating.toString(),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = "rating",
                                    modifier = Modifier.size(9.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = item.appSize.toReadableAppSize(),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}