package com.heiwalocal.fullstackapplicantandroidapp.screens.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.components.LoginTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.inputfields.InputLine
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val localContext = LocalContext.current

    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        topBar = {
            LoginTopBar()
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
            InputLine(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = email,
                onValueChange = {email = it},
                placeholder = {
                    Text(
                        text = "Почта"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Email,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
            )
            InputLine(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = password,
                onValueChange = {password = it},
                placeholder = {
                    Text(
                        text = "Пароль"
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    if (passwordVisible) {
                        IconButton(onClick = { passwordVisible = false }) {
                            Icon(imageVector = Icons.Default.Visibility, contentDescription = null)
                        }
                    } else {
                        IconButton(onClick = { passwordVisible = true }) {
                            Icon(imageVector = Icons.Default.VisibilityOff, contentDescription = null)
                        }
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                onDoneClick = {
                    coroutineScope.launch {
                        val isAuth = viewModel.login(
                            email = email,
                            password = password
                        )
                        Log.e("tess", isAuth.toString())
                        if (isAuth) {
                            Toast.makeText(localContext, "Успешно", Toast.LENGTH_SHORT)
                            navController.navigate(NavigationRouter.Home.route) {
                                popUpTo(NavigationRouter.Home.route) {
                                    inclusive = true
                                }
                            }
                        } else {
                            Toast.makeText(localContext, "Ошибка", Toast.LENGTH_SHORT)
                        }
                    }
                }
            )
            LargeButton(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                onClick = {
                    coroutineScope.launch {
                        val isAuth = viewModel.login(
                            email = email,
                            password = password
                        )
                        Log.e("tess", isAuth.toString())
                        if (isAuth) {
                            Toast.makeText(localContext, "Успешно", Toast.LENGTH_SHORT)
                            navController.navigate(NavigationRouter.Home.route) {
                                popUpTo(NavigationRouter.Home.route) {
                                    inclusive = true
                                }
                            }
                        } else {
                            Toast.makeText(localContext, "Ошибка", Toast.LENGTH_SHORT)
                        }
                    }
                }
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
                        .clickable {
                            navController.navigate(NavigationRouter.SignUp.route) {
                                popUpTo(NavigationRouter.SignUp.route) {
                                    inclusive = true
                                }
                            }
                        },
                    text = "Создайте аккаунт!"
                )
            }
        }
    }
}