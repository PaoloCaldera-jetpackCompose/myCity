package com.example.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Datasource
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import com.example.mycity.viewmodel.MyCityViewModel

@Composable
fun MyCityExpanded(
    uiState: UiState,
    viewModel: MyCityViewModel,
    modifier: Modifier = Modifier
) {
    PermanentNavigationDrawer(drawerContent = {
        PermanentDrawerSheet(modifier = Modifier.width(256.dp)) {
            NavigationDrawerItem(
                label = {
                    Text(text = stringResource(R.string.home_category))
                },
                selected = uiState.selectedScreen == MyCityScreen.Welcome,
                onClick = { viewModel.updateSelectedScreen(MyCityScreen.Welcome) },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = stringResource(R.string.home_button),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )

            for (category in Datasource.getCategories()) {
                NavigationDrawerItem(
                    label = {
                        Text(text = stringResource(category.name))
                    },
                    selected = uiState.selectedCategory == category && uiState.selectedScreen != MyCityScreen.Welcome,
                    onClick = { viewModel.updateSelectedCategory(category) },
                    icon = {
                        Icon(
                            painter = painterResource(category.image),
                            contentDescription = stringResource(category.name),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    }, modifier = modifier.padding(4.dp)) {
        if (uiState.selectedScreen == MyCityScreen.Welcome) {
            WelcomeScreen(
                onClick = { viewModel.updateSelectedScreen(MyCityScreen.Categories) },
                modifier = modifier.padding(4.dp)
            )
        } else {
            BackHandler { viewModel.updateSelectedScreen(MyCityScreen.Welcome) }
            Row {
                CategoryEntriesScreen(
                    entries = Datasource.getEntries(uiState.selectedCategory.id),
                    onClick = { viewModel.updateSelectedEntry(it) },
                    modifier = Modifier
                        .width(512.dp)
                        .padding(4.dp)
                )
                DetailsScreen(
                    entry = uiState.selectedEntry,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )
            }
        }
    }
}