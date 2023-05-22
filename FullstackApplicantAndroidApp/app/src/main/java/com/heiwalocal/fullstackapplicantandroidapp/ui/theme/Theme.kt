package com.heiwalocal.fullstackapplicantandroidapp.ui.theme

import android.app.Activity
import android.view.View
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorPalette = darkColors(
    primary = Color(0xFFFBFBFB),
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
    val fullNameInputLineBackground: Color,
    val fullNameInputLinePlaceholder: Color,
    val fullNameInputLineIcon: Color,
    val fullNameInputLineText: Color,
    val screenBackground: Color,
    val text: Color,
    val hint: Color,
    val close: Color,
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
        fullNameInputLineBackground = Color(0xFF000000),
        fullNameInputLinePlaceholder = Color(0x80000000),
        fullNameInputLineIcon = Color(0x80000000),
        fullNameInputLineText = Color(0x80000000),
        screenBackground = Color(0xFF161616),
        text = Color(0xFF161616),
        hint = Color(0xFF161616),
        close = Color(0xFF161616),
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
        fullNameInputLineBackground = Color(0xFFFFFFFF),
        fullNameInputLinePlaceholder = Color(0x80000000),
        fullNameInputLineIcon = Color(0x80000000),
        fullNameInputLineText = Color(0xFF000000),
        screenBackground = Color(0xFFFBFBFB),
        text = Color(0xFF161616),
        hint = Color(0x80161616),
        close = Color(0xFFA84C4C),
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
        fullNameInputLineBackground = Color.Unspecified,
        fullNameInputLinePlaceholder = Color.Unspecified,
        fullNameInputLineIcon = Color.Unspecified,
        fullNameInputLineText = Color.Unspecified,
        screenBackground = Color.Unspecified,
        text = Color.Unspecified,
        hint = Color.Unspecified,
        close = Color.Unspecified,
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

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = extendedColors.screenBackground.toArgb()
            window.navigationBarColor = extendedColors.screenBackground.toArgb()

//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            if (darkTheme) {
                // Draw light icons on a dark background color
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                // Draw dark icons on a light background color
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }

//            WindowCompat.getInsetsController(window, view)?.isAppearanceLightStatusBars = darkTheme
//            WindowCompat.getInsetsController(window, view)?.isAppearanceLightNavigationBars = darkTheme
        }
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
    val typography = Typography
}