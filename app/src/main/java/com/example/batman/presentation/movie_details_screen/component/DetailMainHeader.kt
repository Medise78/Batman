package com.example.batman.presentation.movie_details_screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.batman.R
import com.example.batman.domain.model.MovieDetails
import com.example.batman.presentation.movies_screen.component.ImageLoader
import com.example.batman.presentation.movies_screen.component.stdPortraitMoviePosterRatio
import com.example.batman.ui.theme.GreenLight
import com.example.batman.ui.theme.Grey4
import com.example.batman.ui.theme.TransFollowingDarkColor2
import com.example.batman.util.formatDurationStr
import com.example.batman.util.formatScoreStr

@Composable
fun DetailMainHeader(
    details: MovieDetails?,
    parentSize: Size
) {
    val boxHeight = (parentSize.width / stdLandscapeMoviePosterRatio) * 14 / 10
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(boxHeight.dp)
    ) {
        MainBg(img = details ?: MovieDetails())
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(vertical = 10.dp)
                .padding(start = 10.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            val mainPosterWidth = parentSize.width / 3.5
            MainPoster(
                img = details?.poster,
                title = details?.title,
                modifier = Modifier.width(mainPosterWidth.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = details?.title ?: "",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                MainHeaderRatingRow(
                    details = details ?: MovieDetails(),
                    modifier = Modifier.padding(end = 10.dp),
                )
                Spacer(modifier = Modifier.height(15.dp))
                GenreList(genre = details?.genre ?: "")
            }
        }
    }
}

@Composable
fun MainBg(
    img: MovieDetails
) {
    BoxWithConstraints(
        modifier = Modifier
            .aspectRatio(stdLandscapeMoviePosterRatio)
            .clip(
                GenericShape { size, layoutDirection ->
                    drawMainBgShape(size)
                }
            )
    ) {
        ImageLoader(
            image = img.poster ?: "",
            contentDes = img.title ?: "",
            shape = RoundedCornerShape(0)
        )
        val imgHeight = maxWidth / stdPortraitMoviePosterRatio
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        .0f to TransFollowingDarkColor2,
                        .6f to Color.Transparent,
                        startY = imgHeight.value,
                        endY = imgHeight.value * .0f
                    )
                )
        )
    }
}

private fun Path.drawMainBgShape(
    size: Size,
) {
    lineTo(0f, size.height * 8 / 10)


    val xControl = size.width / 2
    val yControl = size.height * 12 / 10

    quadraticBezierTo(
        xControl,
        yControl,
        size.width,
        size.height * 8 / 10,
    )

    lineTo(size.width, 0f)
    close()
}

@Composable
fun MainPoster(
    img: String?,
    title: String?,
    modifier: Modifier = Modifier
) {
    val cardShape = RoundedCornerShape(size = 15.dp)
    Card(
        shape = cardShape,
        modifier = modifier
            .aspectRatio(stdPortraitMoviePosterRatio)
            .shadow(elevation = 10.dp, shape = cardShape),
    ) {
        Box {
            ImageLoader(image = img ?: "", contentDes = title ?: "", shape = cardShape)
            if (img == null) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun MainHeaderRatingRow(
    details: MovieDetails,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = stringResource(id = R.string.star_movie)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = details.imdbRating ?: "")
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = Icons.Outlined.Warning,
            contentDescription = stringResource(id = R.string.star_movie),
            tint = GreenLight
        )
        Spacer(modifier = Modifier.width(10.dp))
        (if (details.runtime.isNullOrBlank()) details.runtime else formatDurationStr(
            details.runtime.split(
                " "
            )[0].toInt()
        ))?.let { Text(text = it) }
    }
}

@Composable
fun GenreList(
    genre: String,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        val genresList = genre.split(",")
        items(genresList) {
            Card(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Grey4,
                modifier = Modifier.wrapContentSize()
            ) {
                Text(
                    text = it,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                )
            }
        }
    }
}

const val stdLandscapeMoviePosterRatio = 18 / 16f