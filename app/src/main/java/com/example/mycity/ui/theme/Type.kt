package com.example.mycity.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycity.R

val Dosis = FontFamily(
    Font(R.font.dosis_extralight, FontWeight.ExtraLight),
    Font(R.font.dosis_regular, FontWeight.Normal),
    Font(R.font.dosis_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    labelSmall = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)