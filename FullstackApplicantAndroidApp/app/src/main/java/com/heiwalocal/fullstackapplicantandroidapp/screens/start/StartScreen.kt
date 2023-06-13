package com.heiwalocal.fullstackapplicantandroidapp.screens.start

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.heiwalocal.fullstackapplicantandroidapp.R
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay

@Composable
fun StartScreen (
    navController: NavController,
    viewModel: StartViewModel
) {
    LaunchedEffect(key1 = true) {
        val isAuth = viewModel.checkAuth()
        if (isAuth) {
            navController.navigate(NavigationRouter.Home.route) {
                popUpTo(NavigationRouter.Home.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(NavigationRouter.Login.route) {
                popUpTo(NavigationRouter.Login.route) {
                    inclusive = true
                }
            }
        }
    }
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.dude_on_chair),
                contentDescription = null
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Найди свою идеальную работу в IT!",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Вместе с FullStack это проще простого",
                textAlign = TextAlign.Center
            )
        }
    }
}