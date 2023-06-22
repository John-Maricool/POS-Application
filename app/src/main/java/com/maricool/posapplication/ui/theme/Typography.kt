package com.maricool.posapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.maricool.posapplication.R

val quickSand = listOf(
    Font(R.font.quicksand_bold, weight = FontWeight.Bold),
    Font(R.font.quicksand_light, weight = FontWeight.Light),
    Font(R.font.quicksand_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_semibold, weight = FontWeight.SemiBold),
    Font(R.font.quicksand_regular, weight = FontWeight.Medium)
)

val typography = Typography(
    bodySmall = TextStyle(
        fontSize = 15.sp,
        fontFamily = FontFamily(quickSand[1]),
    ),
    bodyMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily(quickSand[2]),
    ),
    bodyLarge = TextStyle(
        fontSize = 23.sp,
        fontFamily = FontFamily(quickSand[3]),
    ),
)