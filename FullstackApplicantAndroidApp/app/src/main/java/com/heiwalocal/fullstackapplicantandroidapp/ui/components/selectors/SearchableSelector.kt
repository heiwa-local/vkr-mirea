package com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchableSelector(
    modifier: Modifier = Modifier,
    items: Array<String>
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(ExtendedTheme.colors.fullNameInputLineBackground)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                value = selectedText,
                onValueChange = { selectedText = it },
                singleLine = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = ExtendedTheme.colors.fullNameInputLineBackground,
                    placeholderColor = ExtendedTheme.colors.fullNameInputLinePlaceholder,
                    leadingIconColor = ExtendedTheme.colors.fullNameInputLineIcon,
                    trailingIconColor = ExtendedTheme.colors.fullNameInputLineIcon,
                    textColor = ExtendedTheme.colors.fullNameInputLineText,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        text = "Выберите направление",
                        maxLines = 1
                    )
                }
            )

            val filteredOptions =
                items.filter { it.contains(selectedText, ignoreCase = true) }
            if (filteredOptions.isNotEmpty()) {
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        // We shouldn't hide the menu when the user enters/removes any character
                    }
                ) {
                    filteredOptions.forEach { item ->
                        DropdownMenuItem(
                            onClick = {
                                selectedText = item
                                expanded = false
                            }
                        ) {
                            Text(text = item)
                        }
                    }
                }
            }
        }
    }
}