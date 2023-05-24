package com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun DeletableTags(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(ExtendedTheme.colors.largeButtonBackground)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = null,
                tint = ExtendedTheme.colors.largeButtonContent
            )
            Text(
                modifier = Modifier
                    .padding(end = 4.dp),
                text = text,
                maxLines = 1,
                color = ExtendedTheme.colors.largeButtonContent
            )
        }
    }
}