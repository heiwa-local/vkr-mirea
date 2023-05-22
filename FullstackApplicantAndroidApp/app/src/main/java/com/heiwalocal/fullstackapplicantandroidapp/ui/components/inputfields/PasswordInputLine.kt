package com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun PasswordInputLine(
    password: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    onDoneClick: () -> Unit = {}
) {

    var visible by remember { mutableStateOf(false) }

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
            value = password,
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = onValueChange,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = ExtendedTheme.colors.passwordInputLineBackground,
                placeholderColor = ExtendedTheme.colors.passwordInputLinePlaceholder,
                leadingIconColor = ExtendedTheme.colors.passwordInputLineIcon,
                trailingIconColor = ExtendedTheme.colors.passwordInputLineIcon,
                textColor = ExtendedTheme.colors.passwordInputLineText,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                if (visible) {
                    IconButton(onClick = { visible = false }) {
                        Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                    }
                } else {
                    IconButton(onClick = { visible = true }) {
                        Icon(imageVector = Icons.Default.VisibilityOff, contentDescription = null)
                    }
                }
            },
            placeholder = { Text(text = "Пароль") }
        )
    }
}