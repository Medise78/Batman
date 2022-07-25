package com.example.batman.presentation.movies_screen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.batman.domain.model.MovieDetails
import com.example.batman.domain.model.Movies
import com.example.batman.presentation.movies_screen.MoviesViewModel
import com.example.batman.ui.theme.TransFollowingDarkColor1
import com.example.batman.ui.theme.TransFollowingDarkColor3


@Composable
fun MovieItem(
    data: Movies,
    onClick: ((String) -> Unit)? = null
) {
    BoxWithConstraints{

        Column(modifier = Modifier.padding(bottom = 10.dp).clickable(
            onClick = { onClick?.let { it(data.imdbID!!) } }
        )) {
            Card(
                modifier = Modifier
                    .aspectRatio(
                        stdPortraitMoviePosterRatio
                    )
                    .shadow(
                        elevation = 5.dp,
                        shape = RoundedCornerShape(CornerSize(15.dp))
                    )
                    ,
                shape = RoundedCornerShape(CornerSize(15.dp))
            ) {
                if (data.poster != null) {
                    ImageLoader(
                        image = data.poster,
                        contentDes = data.title ?: "",
                        shape = MaterialTheme.shapes.medium,
                    )
                }
            }
            Text(
                text = data.title ?: "",
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 20.dp , start = 10.dp),
                color = TransFollowingDarkColor3
            )
            data.year?.also { date ->
                Text(
                    text = date,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        start = 10.dp
                    ),
                    color = TransFollowingDarkColor3
                )
            }
        }
    }
}

const val stdPortraitMoviePosterRatio = 100 / 144f