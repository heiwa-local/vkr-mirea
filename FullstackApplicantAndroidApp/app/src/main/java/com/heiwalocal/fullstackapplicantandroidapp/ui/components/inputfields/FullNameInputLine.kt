package com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun FullNameInputLine(
    fullName: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .background(ExtendedTheme.colors.fullNameInputLineBackground)
    ) {
        TextField(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            value = fullName,
            onValueChange = onValueChange,
            singleLine = true,
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
            leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            placeholder = { Text(text = "ФИО") }
        )
    }
}