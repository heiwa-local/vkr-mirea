package com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun JobsPostingsTopBar(

) {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = ExtendedTheme.colors.screenBackground,
        contentColor = ExtendedTheme.colors.emailInputLineText,
        elevation = 0.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = "Отклики",
            style = ExtendedTheme.typography.h1,
            color = ExtendedTheme.colors.text
        )
    }
}