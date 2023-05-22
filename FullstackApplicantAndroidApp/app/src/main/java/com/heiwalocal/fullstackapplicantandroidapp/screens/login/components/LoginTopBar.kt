package com.heiwalocal.fullstackapplicantandroidapp.screens.login.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun LoginTopBar(

) {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = ExtendedTheme.colors.screenBackground,
        contentColor = ExtendedTheme.colors.emailInputLineText,
        elevation = 0.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = "")
    }
}