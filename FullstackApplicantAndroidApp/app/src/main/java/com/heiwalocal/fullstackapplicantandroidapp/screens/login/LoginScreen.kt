package com.heiwalocal.fullstackapplicantandroidapp.screens.login

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.EmailInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.PasswordInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun LoginScreen(

) {
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
                text = "Добро пожаловать!",
                style = MaterialTheme.typography.h1,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = "Введите логин и пароль для входа в систему",
                style = MaterialTheme.typography.body1
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
                    text = "Войти"
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Впервые тут? "
                )
                Text(
                    modifier = Modifier
                        .clickable { Log.e("asdasd", "123") },
                    text = "Создайте аккаунт!"
                )
            }
        }
    }
}