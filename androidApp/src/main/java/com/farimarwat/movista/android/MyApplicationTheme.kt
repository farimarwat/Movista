package com.farimarwat.movista.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            secondary = Color(0xFF03DAC5),
            tertiary = Color(0xFF3700B3)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF1DA1F2),
            onPrimary = Color.White,
            primaryContainer = Color(0xFFD0E8FF),
            onPrimaryContainer = Color(0xFF003A75),

            secondary = Color(0xFF03DAC5),
            onSecondary = Color.Black,

            tertiary = Color(0xFF3700B3),
            onTertiary = Color.White,

            background = Color.White,
            onBackground = Color.Black,

            surface = Color(0xFFF5F5F5),
            onSurface = Color.Black,

            surfaceVariant = Color(0xFFE1E8ED),
            onSurfaceVariant = Color.Black,

            error = Color(0xFFD32F2F),
            onError = Color.White
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
