package com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.heiwalocal.fullstackapplicantandroidapp.navigation.components.AppBottomNavBar
import com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.components.JobsPostingsTopBar
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.MediumJobPostingCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.components.cards.MediumResumeCard
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.ExtendedTheme

@Composable
fun JobsPostingsScreen(
    navController: NavHostController,
    viewModel: JobsPostingViewModel
) {

    val jobsPostings = viewModel.jobsPostings.observeAsState(initial = null).value

    LaunchedEffect(key1 = true) {
        viewModel.getJobsPostings()
    }
    Scaffold(
        backgroundColor = ExtendedTheme.colors.screenBackground,
        bottomBar = {
            AppBottomNavBar(navController)
        },
        topBar = {
            JobsPostingsTopBar()
        }
    ) {
        if (jobsPostings != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(jobsPostings) {
                    MediumJobPostingCard(
                        organizationName = it.organizationName.toString(),
                        organizationLogoUrl = it.organizationLogoUrl.toString(),
                        jobTitle = it.jobTitle.toString(),
                        status = it.status.toString(),
                        datetime = it.datetime.toString(),
                        onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                "clicked_vacancy",
                                it.vacancyId
                            )
                            navController.navigate("vacancydetail")
                        }
                    )
                }
            }
        }
    }
}