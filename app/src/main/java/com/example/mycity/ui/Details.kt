package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycity.R

@Composable
fun DetailsScreen() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.hotel_6_image),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text(
                text = stringResource(R.string.hotel_6_description),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = stringResource(R.string.hotel_6_address),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall
        )
    }
}