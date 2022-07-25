package com.example.batman.util

const val BASE_URL = "http://www.omdbapi.com/"

fun formatScoreStr(score: Number): String = String.format("%.1f", score.toFloat()) +" %"
fun formatDurationStr(minutes: Number): String {
    val minInt = minutes.toInt()

    return if(minInt <= 60) "${minInt}m"
    else "${minInt /60}h ${minInt %60}m"
}
