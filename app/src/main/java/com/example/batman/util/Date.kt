package com.example.batman.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.sdFormat(
    isMonthLong:Boolean = true
):String{
    val sdf = SimpleDateFormat("yyyy MMM dd" , Locale.getDefault())
    return sdf.format(this)
}