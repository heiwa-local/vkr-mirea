package com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields

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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputLine(
    value: String,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    placeholder: @Composable() (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onDoneClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onSendClick: () -> Unit = {},
    onValueChange: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

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
            value = value,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
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
            keyboardActions = KeyboardActions(
                onDone = {
                    onDoneClick()
                    keyboardController?.hide()
                },
                onNext = {

                    focusManager.moveFocus(FocusDirection.Down)
                },
                onSend = {
                    onSendClick()
                }
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeholder = placeholder
        )
    }
}