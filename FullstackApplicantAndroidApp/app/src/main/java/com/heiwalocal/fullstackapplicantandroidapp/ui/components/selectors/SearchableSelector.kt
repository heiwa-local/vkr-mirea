package com.heiwalocal.fullstackapplicantandroidapp.ui.components.selectors

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchableSelector(
    value: String,
    modifier: Modifier = Modifier,
    items: List<String>,
    onDoneClick: () -> Unit = {},
    onValueChange: (String) -> Unit,
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
                expanded = !expanded
            }
        ) {
            TextField(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                value = value,
                onValueChange = { onValueChange(it) },
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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onDoneClick()
                        keyboardController?.hide()
                    }
                ),
                placeholder = {
                    Text(
                        text = "Выберите направление",
                        maxLines = 1
                    )
                }
            )

            val filteredOptions =
                items.filter { it.contains(value, ignoreCase = true) }
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
}