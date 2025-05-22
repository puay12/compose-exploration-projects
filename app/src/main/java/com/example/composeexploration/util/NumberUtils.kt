package com.example.composeexploration.util

import kotlin.math.roundToLong

fun Long.toReadableAppSize() : String {
    var result = this * 0.0009765625
    var prefix = "MB"

    if (result >= 1024) {
        result = result / 1024
        prefix = "GB"
    }

    return "${result.roundToLong()} $prefix"
}