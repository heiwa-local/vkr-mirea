package com.heiwalocal.fullstackapplicantandroidapp.di

import com.heiwalocal.domain.usecases.*
import com.heiwalocal.fullstackapplicantandroidapp.screens.addresume.AddResumeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.home.HomeViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings.JobsPostingViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.login.LoginViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.profile.ProfileViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail.ResumeDetailViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.resumes.ResumesViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.signup.SignUpViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.start.StartViewModel
import com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo.VacancyInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SearchViewModel(get(), get()) }
    viewModel { VacancyInfoViewModel(get(), get(), get(), get()) }
    viewModel { StartViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { ProfileViewModel(get(), get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { AddResumeViewModel(get(), get()) }
    viewModel { ResumesViewModel(get()) }
    viewModel { JobsPostingViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { ResumeDetailViewModel(get(), get()) }
}

val useCasesModule = module {
    single { GetVacanciesByKeywordsUseCase() }
    single { GetVacancyInfoByVacancyIdUseCase() }
    single { GetResumesUseCase() }
    single { PostJobPostingUseCase() }
    single { CheckAuthUseCase() }
    single { LoginUseCase() }
    single { LogoutUseCase() }
    single { SignUpUseCase() }
    single { GetDirectionsUseCase() }
    single { CreateResumeUseCase() }
    single { GetGradesUseCase() }
    single { GetJobsPostingsUseCase() }
    single { DeleteJobPostingUseCase() }
    single { GetLastAddedVacanciesUseCase() }
    single { GetRecommendedVacanciesUseCase() }
    single { GetResumeUseCase() }
    single { DeleteResumeUseCase() }
    single { GetApplicantUseCase() }
}