package com.heiwalocal.fullstackapplicantandroidapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LargeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    component: @Composable() () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4CA6A8),
            contentColor = Color(0xFFFFFFFF)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            component()
        }
    }
}