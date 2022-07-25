package com.example.batman.presentation.movie_details_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.batman.domain.model.MovieDetails
import com.example.batman.R
import com.example.batman.ui.theme.font
import com.example.batman.ui.theme.fontSize

@Composable
fun DetailSection(
    details: MovieDetails?
) {
    if (details != null){
        Column {
            Spacer(modifier = Modifier.height(15.dp))
            Info(data = details)
            Overview(text = details.plot?:"")
        }
    }
}

@Composable
private fun Overview(
    text: String,
) {
    Column(
        modifier = Modifier.padding(
            horizontal = 10.dp,
        ),
    ) {
        Text(
            text = "Overview",
            fontFamily = font,
            fontSize = fontSize
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = text,)
    }
}

@Composable
fun Info(
    data:MovieDetails
) {
    Column(
        modifier = Modifier.padding(
            horizontal = 10.dp
        )
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = font , fontSize = fontSize) ){
                    append("Release Date: ")
                }
                append(data.released?:"")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth().alpha(0.8f).align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = font , fontSize = fontSize) ){
                    append("Directors: ")
                }
                append(data.director?:"")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth().alpha(0.8f).align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = font , fontSize = fontSize) ){
                    append("Writer: ")
                }
                append(data.writer?:"")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth().alpha(0.8f).align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = font , fontSize = fontSize) ){
                    append("Actors: ")
                }
                append(data.actors?:"")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth().alpha(0.8f).align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontFamily = font , fontSize = fontSize) ){
                    append("Language: ")
                }
                append(data.language?:"")
            }
        )
        Spacer(modifier = Modifier.height(5.dp))
        Divider(modifier = Modifier.fillMaxWidth().alpha(0.8f).align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(5.dp))
    }
}