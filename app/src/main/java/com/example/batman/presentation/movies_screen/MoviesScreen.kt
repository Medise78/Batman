package com.example.batman.presentation.movies_screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.batman.presentation.movies_screen.component.MovieItem
import com.example.batman.ui.theme.ValoLightBlue
import com.example.batman.util.Screen
import com.example.batman.R
import com.example.batman.ui.theme.TransFollowingDarkColor1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    listState: LazyListState = rememberLazyListState(),
    navController: NavController
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = TransFollowingDarkColor1
        ) {
//            Image(
//                painter = rememberImagePainter(data = R.drawable.bat),
//                contentDescription = "",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .alpha(0.3f),
//                contentScale = ContentScale.FillHeight.also { ContentScale.FillWidth }
//            )

            if (state.movies.isNotEmpty()) {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxHeight(),
                    state = listState
                ) {
                    items(state.movies) { movie ->
                        Box(modifier = Modifier.padding(10.dp)) {
                            MovieItem(
                                data = movie,
                                onClick = { navController.navigate(Screen.DetailScreen.route + "/${movie.imdbID}") })
                        }
                    }
                }
            } else if (state.loading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}