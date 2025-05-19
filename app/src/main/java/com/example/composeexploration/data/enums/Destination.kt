package com.example.composeexploration.data.enums

enum class Destination(val label: String, val route: String) {
    FOR_YOU("For You", "/for-you"),
    TOP_CHARTS("Top Charts", "/top-charts"),
    KIDS("Kids", "/kids"),
    CATEGORIES("Categories", "/categories")
}