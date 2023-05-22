package com.heiwalocal.fullstackapplicantandroidapp.screens.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun HomeTopBar(

) {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = Color.Transparent,
        contentColor =  ExtendedTheme.colors.text,
        elevation = 0.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = "Главная 👋🏻",
            style = ExtendedTheme.typography.h1,
            color = ExtendedTheme.colors.text
        )
    }
}