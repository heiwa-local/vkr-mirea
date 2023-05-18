package com.heiwalocal.fullstackapplicantandroidapp.screens.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.EmailInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.FullNameInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.PasswordInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun SignUpScreen(

) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(16.dp),
                title = {
                        Text(text = "")
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .padding(top = 20.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = null
                            )
                            Text(text = "Вход")
                        }
                    }
                },
                backgroundColor = ExtendedTheme.colors.screenBackground,
                contentColor = ExtendedTheme.colors.emailInputLineText,
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Регистрация",
                style = MaterialTheme.typography.h1,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = "Введите данные представленные в форме для создания акаунта в системе",
                style = MaterialTheme.typography.body1
            )
            FullNameInputLine(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                fullName = fullName,
                onValueChange = {
                    fullName = it
                }
            )
            EmailInputLine(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                email = email,
                onValueChange = {
                    email = it
                }
            )
            PasswordInputLine(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                password = password,
                onValueChange = {
                    password = it
                }
            )
            LargeButton(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Зарегистрироваться"
                )
            }
        }
    }
}