package com.heiwalocal.fullstackapplicantandroidapp.screens.resumes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.NavigationRouter
import com.heiwalocal.fullstackapplicantandroidapp.navigation.components.AppBottomNavBar
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.components.ResumeTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.MediumResumeCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun ResumesScreen(
    navController: NavHostController,
    viewModel: ResumesViewModel
) {

    val resumes = viewModel.resumes.observeAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.getResumes()
    }
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        bottomBar = {
            AppBottomNavBar(navController)
        },
        topBar = {
            ResumeTopBar(
                navController = navController
            )
        }
    ) {
        if (resumes != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(resumes) {
                    MediumResumeCard(
                        jobTitle = it.jobTitle.toString(),
                        salary = it.salary.toString(),
                        datetime = it.datetime.toString(),
                        onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set("clicked_resume", it.id)
                            navController.navigate(NavigationRouter.ResumeDetail.route)
                        }
                    )
                }
            }
        }
    }
}