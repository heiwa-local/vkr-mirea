package com.heiwalocal.fullstackapplicantandroidapp.screens.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun SearchTopBar(
    navController: NavHostController
) {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = ExtendedTheme.colors.screenBackground,
        contentColor = ExtendedTheme.colors.emailInputLineText,
        elevation = 0.dp,
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Поиск",
                style = ExtendedTheme.typography.h1,
                color = ExtendedTheme.colors.text
            )
            IconButton(
                modifier = Modifier,
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = ExtendedTheme.colors.text
                )
            }
        }
    }
}