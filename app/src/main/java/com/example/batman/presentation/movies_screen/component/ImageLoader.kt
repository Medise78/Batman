package com.example.batman.presentation.movies_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.batman.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImageLoader(
    image: String,
    contentDes: String,
    shape: Shape
) {
    GlideImage(
        imageModel = image,
        placeHolder = rememberImagePainter(data = R.drawable.ic_image_not_available),
        error = rememberImagePainter(data = R.drawable.ic_image_not_available),
        alignment = Alignment.Center,
        contentScale = ContentScale.FillBounds,
        circularReveal = CircularReveal(),
        contentDescription = contentDes,
        modifier = Modifier
            .fillMaxSize()
            .clip(shape)
    )
}