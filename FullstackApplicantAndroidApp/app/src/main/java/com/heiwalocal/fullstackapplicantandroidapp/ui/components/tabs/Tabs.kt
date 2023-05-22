package com.heiwalocal.fullstackapplicantandroidapp.ui.components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    selected: String,
    onSelectedChange: (String) -> Unit,
    items: Array<String>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        if (it == selected) {
                            ExtendedTheme.colors.largeButtonBackground
                        } else {
                            ExtendedTheme.colors.largeButtonContent
                        }
                    )
                    .clickable {
                        onSelectedChange(it)
                    }
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp)
                    ,
                    text = it
                )
            }
        }
    }
}