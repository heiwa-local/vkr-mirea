package com.heiwalocal.fullstackapplicantandroidapp.screens.profile.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun ProfileTopBar(
    navController: NavHostController
) {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = ExtendedTheme.colors.screenBackground,
        contentColor = ExtendedTheme.colors.emailInputLineText,
        elevation = 0.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = "Профиль",
            style = ExtendedTheme.typography.h1,
            color = ExtendedTheme.colors.text
        )
    }
}