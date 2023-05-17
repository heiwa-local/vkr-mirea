package com.heiwalocal.fullstackapplicantandroidapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
data class ExtendedColors(
    val largeButtonBackground: Color,
    val largeButtonContent: Color,
    val emailInputLineBackground: Color,
    val emailInputLinePlaceholder: Color,
    val emailInputLineIcon: Color,
    val emailInputLineText: Color,
    val passwordInputLineBackground: Color,
    val passwordInputLinePlaceholder: Color,
    val passwordInputLineIcon: Color,
    val passwordInputLineText: Color,
    val screenBackground: Color,
)

private val ExtendedDarkColorPalette by lazy {
    ExtendedColors(
        largeButtonBackground = Color(0xFF4CA6A8),
        largeButtonContent = Color(0xFF4CA6A8),
        emailInputLineBackground = Color(0xFFFFFFFF),
        emailInputLinePlaceholder = Color(0x80000000),
        emailInputLineIcon = Color(0xFF000000),
        emailInputLineText = Color.White,
        passwordInputLineBackground = Color(0xFF000000),
        passwordInputLinePlaceholder = Color(0x80000000),
        passwordInputLineIcon = Color(0x80000000),
        passwordInputLineText = Color(0x80000000),
        screenBackground = Color(0xFFFBFBFB)
    )
}

private val ExtendedLightColorPalette by lazy {
    ExtendedColors(
        largeButtonBackground = Color(0xFF4CA6A8),
        largeButtonContent = Color(0xFFFFFFFF),
        emailInputLineBackground = Color(0xFFFFFFFF),
        emailInputLinePlaceholder = Color(0x80000000),
        emailInputLineIcon = Color(0x80000000),
        emailInputLineText = Color(0xFF000000),
        passwordInputLineBackground = Color(0xFFFFFFFF),
        passwordInputLinePlaceholder = Color(0x80000000),
        passwordInputLineIcon = Color(0x80000000),
        passwordInputLineText = Color(0xFF000000),
        screenBackground = Color(0xFFFBFBFB)
    )
}

val ExtendedLocalColorPalette = staticCompositionLocalOf {
    ExtendedColors(
        largeButtonBackground = Color.Unspecified,
        largeButtonContent = Color.Unspecified,
        emailInputLineBackground = Color.Unspecified,
        emailInputLinePlaceholder = Color.Unspecified,
        emailInputLineIcon = Color.Unspecified,
        emailInputLineText = Color.Unspecified,
        passwordInputLineBackground = Color.Unspecified,
        passwordInputLinePlaceholder = Color.Unspecified,
        passwordInputLineIcon = Color.Unspecified,
        passwordInputLineText = Color.Unspecified,
        screenBackground = Color.Unspecified,
    )
}

@Composable
fun FullstackApplicantAndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) {
        ExtendedDarkColorPalette
    } else {
        ExtendedLightColorPalette
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        ExtendedLocalColorPalette provides extendedColors,
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

object ExtendedTheme {
    val colors: ExtendedColors
        @Composable
        @ReadOnlyComposable
        get() = ExtendedLocalColorPalette.current
    val typography = kotlin.text.Typography
}