package com.yunjung.myblue.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = pointColor ,
    primaryVariant = mainColor ,
    secondary = polaroid
)

private val LightColorPalette = lightColors(
    primary = pointColor ,
    primaryVariant = mainColor ,
    secondary = polaroid

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MyBlueTheme(darkTheme: Boolean = isSystemInDarkTheme() , content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors ,
        typography = Typography ,
        shapes = Shapes ,
        content = content
    )
}