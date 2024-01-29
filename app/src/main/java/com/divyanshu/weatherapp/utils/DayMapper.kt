package com.divyanshu.weatherapp.utils

fun Int?.toWeekDay(): String {
    return when (this) {
        0 -> "Sunday"
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        else -> "Unknown Day"
    }
}