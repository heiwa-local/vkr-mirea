package com.heiwalocal.fullstackapplicantandroidapp.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun ClickableTags(
    modifier: Modifier = Modifier,
    selectedColor: Color,
    unselectedColor: Color,
    text: String,
    onClick: (Boolean) -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) {selectedColor} else {unselectedColor})
            .clickable {
                selected = !selected
                onClick(selected)
            }
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            text = text,
            textAlign = TextAlign.Center
        )
    }
}