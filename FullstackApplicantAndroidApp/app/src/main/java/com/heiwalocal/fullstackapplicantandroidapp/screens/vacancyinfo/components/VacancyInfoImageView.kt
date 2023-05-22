package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun VacancyInfoImageView(
    organizationLogoUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(ExtendedTheme.colors.largeButtonContent)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = organizationLogoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}