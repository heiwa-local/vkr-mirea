package com.heiwalocal.fullstackapplicantandroidapp.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter
import com.heiwalocal.fullstackapplicantandroidapp.navigation.components.AppBottomNavBar
import com.heiwalocal.fullstackapplicantandroidapp.screens.profile.components.ProfileTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.LargeButton
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navController: NavHostController
) {
    val applicant = viewModel.applicant.observeAsState().value

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.getApplicant()
    }
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            AppBottomNavBar(navController)
        },
        topBar = {
            ProfileTopBar(navController = navController)
        },
        backgroundColor = ExtendedTheme.colors.screenBackground
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Персональная информация",
                style = ExtendedTheme.typography.h2,
                color = ExtendedTheme.colors.text,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = applicant?.name.toString()
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Phone,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = applicant?.phone.toString()
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(ExtendedTheme.colors.largeButtonContent)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Email,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier
                            .padding(16.dp),
                        text = applicant?.email.toString()
                    )
                }
            }
            LargeButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = {
                    coroutineScope.launch {
                        if (viewModel.logout()) {
                            navController.navigate(NavigationRouter.Login.route) {
                                popUpTo(NavigationRouter.Login.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                },
                backgroundColor = ExtendedTheme.colors.close
            ) {
                Text(text = "Выйти")
            }
        }
    }
}