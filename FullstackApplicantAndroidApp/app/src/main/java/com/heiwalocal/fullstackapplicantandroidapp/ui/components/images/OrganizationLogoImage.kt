package com.heiwalocal.fullstackapplicantandroidapp.ui.components.images

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun OrganizationLogoImage(
    size: Dp,
    url: String
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(ExtendedTheme.colors.largeButtonContent)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}