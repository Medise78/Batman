package com.example.batman.presentation.splash_screen


import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.batman.R
import com.example.batman.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT > 28){
                add(ImageDecoderDecoder.Factory())
            }else{
                add(GifDecoder.Factory())
            }
        }.build()

    LaunchedEffect(key1 = true) {
        delay(2600L)
        navController.navigate(Screen.HomeScreen.route){
            navController.popBackStack()
        }
    }

    Column(modifier = Modifier.fillMaxSize().background(Color.White) , horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .fillMaxSize()
             , contentAlignment = Alignment.Center) {
            Image(painter = rememberImagePainter(data = R.raw.bat , imageLoader = imageLoader) ,
                contentDescription = "Logo" ,
                modifier = Modifier.fillMaxSize(0.7f))
        }
    }
}