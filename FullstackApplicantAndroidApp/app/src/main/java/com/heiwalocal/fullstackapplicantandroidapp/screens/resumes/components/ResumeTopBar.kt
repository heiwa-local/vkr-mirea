package com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun ResumeTopBar(
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
                text = "Резюме",
                style = ExtendedTheme.typography.h1,
                color = ExtendedTheme.colors.text
            )
            IconButton(onClick = {
                navController.navigate(NavigationRouter.AddResume.route)
            }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    tint = ExtendedTheme.colors.text
                )
            }
        }
    }
}