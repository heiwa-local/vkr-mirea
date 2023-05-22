package com.heiwalocal.fullstackapplicantandroidapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.heiwalocal.fullstackapplicantandroidapp.screens.addresume.AddResumeScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.addresume.AddResumeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.JobsPostingViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.JobsPostingsScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.profile.ProfileScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.profile.ProfileViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail.ResumeDetailScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail.ResumeDetailViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.ResumesScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.ResumesViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.start.StartScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.start.StartViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.VacancyInfoScreen
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.VacancyInfoViewModel

@ExperimentalMaterialApi
@Composable
fun AppNavigation(
    searchViewModel: SearchViewModel,
    vacancyDetailViewModel: VacancyInfoViewModel,
    startViewModel: StartViewModel,
    loginViewModel: LoginViewModel,
    profileViewModel: ProfileViewModel,
    signUpViewModel: SignUpViewModel,
    addResumeViewModel: AddResumeViewModel,
    resumesViewModel: ResumesViewModel,
    jobsPostingViewModel: JobsPostingViewModel,
    homeViewModel: HomeViewModel,
    resumeDetailViewModel: ResumeDetailViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationRouter.Start.route
        ) {
            composable(NavigationRouter.Start.route
            ) {
                StartScreen(
                    navController = navController,
                    viewModel = startViewModel
                )
            }
            composable(NavigationRouter.Home.route) {
                HomeScreen(
                    navController = navController,
                    viewModel = homeViewModel
                )
            }
            composable(NavigationRouter.Search.route
                ) {
                SearchScreen(
                    navController = navController,
                    viewModel = searchViewModel,
                )
            }
            composable(NavigationRouter.VacancyDetail.route
            ) {
                VacancyInfoScreen(
                    navController = navController,
                    viewModel = vacancyDetailViewModel
                )
            }
            composable(NavigationRouter.Resumes.route
            ) {
                ResumesScreen(
                    navController = navController,
                    viewModel = resumesViewModel
                )
            }
            composable(NavigationRouter.AddResume.route
            ) {
                AddResumeScreen(
                    navController = navController,
                    viewModel = addResumeViewModel
                )
            }
            composable(NavigationRouter.JobsPostings.route
            ) {
                JobsPostingsScreen(
                    navController = navController,
                    viewModel = jobsPostingViewModel
                )
            }
            composable(NavigationRouter.Login.route
            ) {
                LoginScreen(
                    navController = navController,
                    viewModel = loginViewModel
                )
            }
            composable(NavigationRouter.Profile.route
            ) {
                ProfileScreen(
                    navController = navController,
                    viewModel = profileViewModel
                )
            }
            composable(NavigationRouter.SignUp.route
            ) {
                SignUpScreen(
                    navController = navController,
                    viewModel = signUpViewModel
                )
            }
            composable(NavigationRouter.ResumeDetail.route
            ) {
                ResumeDetailScreen(
                    navController = navController,
                    viewModel = resumeDetailViewModel
                )
            }
        }
    }
}