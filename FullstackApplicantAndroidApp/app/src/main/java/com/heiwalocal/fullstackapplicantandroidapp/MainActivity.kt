package com.heiwalocal.fullstackapplicantandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import com.heiwalocal.fullstackapplicantandroidapp.navigation.AppNavigation
import com.heiwalocal.fullstackapplicantandroidapp.screens.addresume.AddResumeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.JobsPostingViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.profile.ProfileViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail.ResumeDetailViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.ResumesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.start.StartViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.VacancyInfoViewModel
import com.heiwalocal.fullstackapplicantandroidapp.ui.theme.FullstackApplicantAndroidAppTheme

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private val searchViewModel by viewModel<SearchViewModel>()
    private val vacancyDetailViewModel by viewModel<VacancyInfoViewModel>()
    private val startViewModel by viewModel<StartViewModel>()
    private val loginViewModel by viewModel<LoginViewModel>()
    private val profileViewModel by viewModel<ProfileViewModel>()
    private val signUpViewModel by viewModel<SignUpViewModel>()
    private val addResumeViewModel by viewModel<AddResumeViewModel>()
    private val resumesViewModel by viewModel<ResumesViewModel>()
    private val jobsPostingViewModel by viewModel<JobsPostingViewModel>()
    private val homeViewModel by viewModel<HomeViewModel>()
    private val resumeDetailViewModel by viewModel<ResumeDetailViewModel>()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FullstackApplicantAndroidAppTheme {
                AppNavigation(
                    searchViewModel = searchViewModel,
                    vacancyDetailViewModel = vacancyDetailViewModel,
                    startViewModel = startViewModel,
                    loginViewModel = loginViewModel,
                    profileViewModel = profileViewModel,
                    signUpViewModel = signUpViewModel,
                    addResumeViewModel = addResumeViewModel,
                    resumesViewModel = resumesViewModel,
                    jobsPostingViewModel = jobsPostingViewModel,
                    homeViewModel = homeViewModel,
                    resumeDetailViewModel = resumeDetailViewModel
                )
            }
        }
    }
}
