package com.example.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.data.Datasource
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import com.example.mycity.ui.CategoriesScreen
import com.example.mycity.ui.CategoryEntriesScreen
import com.example.mycity.ui.DetailsScreen
import com.example.mycity.ui.WelcomeScreen
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.viewmodel.MyCityViewModel

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

    // Import the viewModel and the UI state
    val viewModel: MyCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

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
                MyCityCompact(
                    uiState = uiState,
                    viewModel = viewModel,
                    modifier = modifier.fillMaxSize().padding(it)
                )
            }
            WindowWidthSizeClass.Medium -> {}
            WindowWidthSizeClass.Expanded -> {}
            else -> {}
        }
    }
}

@Composable
fun MyCityCompact(
    uiState: UiState,
    viewModel: MyCityViewModel,
    modifier: Modifier = Modifier
) {
    when (uiState.selectedScreen) {
        MyCityScreen.Welcome -> {
            WelcomeScreen(
                onClick = { viewModel.updateSelectedScreen(MyCityScreen.Categories) },
                modifier = modifier
            )
        }
        MyCityScreen.Categories -> {
            CategoriesScreen(
                categories = Datasource.getCategories(),
                onClick = { viewModel.updateSelectedCategory(it) },
                modifier = modifier
            )
        }
        MyCityScreen.Entries -> {
            CategoryEntriesScreen(
                entries = Datasource.getEntries(uiState.selectedCategory.id),
                onClick = { viewModel.updateSelectedEntry(it) },
                modifier = modifier
            )
        }
        MyCityScreen.Details -> {
            DetailsScreen(
                entry = uiState.selectedEntry,
                modifier = modifier
            )
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