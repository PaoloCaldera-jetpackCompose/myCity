package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.ui.WelcomeScreen
import com.example.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(activity = this)
                    MyCityApp(widthSizeClass = windowSizeClass.widthSizeClass)
                }
            }
        }
    }
}

@Composable
fun MyCityApp(widthSizeClass: WindowWidthSizeClass, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { MyCityAppBar(widthSizeClass = widthSizeClass) }
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.main_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .alpha(0.10f)
                    .matchParentSize()
            )
        }
        when (widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                WelcomeScreen(paddingValues = it)
            }
            WindowWidthSizeClass.Medium -> {}
            WindowWidthSizeClass.Expanded -> {}
            else -> {}
        }
    }
}

@Composable
fun MyCityAppBar(widthSizeClass: WindowWidthSizeClass, modifier: Modifier = Modifier) {
    
}


@Preview(showBackground = true)
@Composable
fun MyCityPreview() {
    MyCityTheme {
        MyCityApp(WindowWidthSizeClass.Compact)
    }
}