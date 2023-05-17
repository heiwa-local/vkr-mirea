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
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun EmailInputLine(
    email: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .background(ExtendedTheme.colors.emailInputLineBackground)
    ) {
        TextField(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = ExtendedTheme.colors.emailInputLineBackground,
                placeholderColor = ExtendedTheme.colors.emailInputLinePlaceholder,
                leadingIconColor = ExtendedTheme.colors.emailInputLineIcon,
                trailingIconColor = ExtendedTheme.colors.emailInputLineIcon,
                textColor = ExtendedTheme.colors.emailInputLineText,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            placeholder = { Text(text = "Почта") }
        )
    }
}