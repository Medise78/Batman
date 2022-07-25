package com.example.batman.presentation.movie_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.batman.domain.model.MovieDetails
import com.example.batman.presentation.movie_details_screen.component.DetailMainHeader
import com.example.batman.presentation.movie_details_screen.component.DetailSection
import kotlinx.coroutines.flow.collectLatest
import com.example.batman.R
import com.example.batman.ui.theme.TransOppositeDarkColor4

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    systemPaddingValues: PaddingValues? = null,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(scaffoldState = scaffoldState) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            DetailMainLayout(
                details = state.movieDetails,
                parentSize = maxSize,
                systemPaddingValues = systemPaddingValues
            )
            val topPadding = systemPaddingValues?.calculateTopPadding() ?: 0.dp

            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(15.dp)
                    .padding(top = topPadding)
                    .size(50.dp)
            ){
                Image(painter = ColorPainter(
                    TransOppositeDarkColor4
                ), contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .clickable {
                        navController.popBackStack()
                    },
                )
                Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null , tint = Color.White , modifier = Modifier.fillMaxSize().padding(10.dp))
            }
        }
    }
}


@Composable
fun DetailMainLayout(
    details: MovieDetails?,
    parentSize: Size,
    systemPaddingValues: PaddingValues?
) {
    Column(
        modifier = Modifier
            .size(
                width = parentSize.width.dp,
                height = parentSize.height.dp
            )
            .verticalScroll(rememberScrollState())
    ) {
        DetailMainHeader(details = details, parentSize = parentSize)
        DetailSection(details = details)
        Spacer(modifier = Modifier.height(systemPaddingValues?.calculateBottomPadding() ?: 0.dp))
    }
}

val BoxWithConstraintsScope.maxSize
    get() = Size(
        width = maxWidth.value,
        height = maxHeight.value,
    )