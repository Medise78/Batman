package com.example.batman.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import com.example.batman.ui.theme.GreenLight

fun getColorPointFromLinearGradient(
    first: Color,
    last: Color,
    point: Double, // from 0.0 - 1.0
): Color {
    if(point <= 0.0) return first
    if(point >= 1.0) return last

    //first.
    //val firstARGB = ARGBColor.fromColor(first);
    //final lastARGB = ARGBColor.fromColor(last);

    val aDiff = last.alpha - first.alpha
    val rDiff = last.red - first.red
    val gDiff = last.green - first.green
    val bDiff = last.blue - first.blue

    val aRes = (aDiff * point).toFloat() + first.alpha
    val rRes = (rDiff * point).toFloat() + first.red
    val gRes = (gDiff * point).toFloat() + first.green
    val bRes = (bDiff * point).toFloat() + first.blue

    return Color(
        alpha = aRes,
        red = rRes,
        green = gRes,
        blue = bRes,
    )
}

fun getScoreColor(
    score: Number,
    scale: Int = 10,
): Color = getColorPointFromLinearGradient(
    first = Red,
    last = GreenLight,
    point = score.toDouble() / scale,
)