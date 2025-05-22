package com.example.composeexploration.data.playstore

import com.example.composeexploration.R

fun getDummyCarouselItems() : List<CarouselItem> {
    return listOf(
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
}

fun getDummyAppItems() : List<AppItem> {
    return listOf<AppItem>(
        AppItem(
            id = 0,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        ),
        AppItem(
            id = 1,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        ),
        AppItem(
            id = 2,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        ),
        AppItem(
            id = 3,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        ),
        AppItem(
            id = 4,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        ),
        AppItem(
            id = 5,
            name = "Traveloka: Book Hotel & Flight",
            company = "Traveloka",
            imageString = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8ZoweV0LHXzLXWW4TO6S3cXaqqvpC142Dg&s",
            rating = 4.8,
            categoryList = listOf(
                "Travel & Local",
                "Accommodation",
                "Flights"
            ),
            appSize = 54272
        )
    )
}