package com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Grade
import androidx.compose.material.icons.rounded.Upgrade
import androidx.compose.material.icons.rounded.WorkOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun Selector(
    value: String,
    modifier: Modifier = Modifier,
    items: List<String>,
    onDoneClick: () -> Unit = {},
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable() () -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(ExtendedTheme.colors.fullNameInputLineBackground)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                if (!expanded) {
                    onValueChange("")
                }
                expanded = !expanded

            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    leadingIcon()
                    Text(
                        text = value
                    )
                }
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            }
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        onClick = {
                            onValueChange(item)
                            onDoneClick()
                            expanded = false
                            keyboardController?.hide()
                        }
                    ) {
                        Text(text = item)
                    }
                }
            }
        }
    }
}