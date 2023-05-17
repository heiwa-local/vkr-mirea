package com.heiwalocal.fullstackapplicantandroidapp.screens.signup

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.EmailInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.PasswordInputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun SignUpScreen(

) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Добро пожаловать!",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Введите логи и пароль или воспользуйтесь социальными сетями",
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