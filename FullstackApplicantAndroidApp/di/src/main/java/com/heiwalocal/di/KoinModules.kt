package com.heiwalocal.di

import com.heiwalocal.data.repositories.*
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.data.services.local.LocalDatabaseService
import com.heiwalocal.data.services.local.database.LocalDatabase
import com.heiwalocal.domain.repositories.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoriesModule = module {

    single { FullstackApiService() }
    single { LocalDatabaseService( LocalDatabase.create(androidContext()) ) }

    single<VacancyRepository> { VacancyRepositoryImpl(get()) }
    single<ResumeRepository> { ResumeRepositoryImpl(get()) }
    single<JobPostingRepository> { JobPostingRepositoryImpl(get(), get()) }
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<DirectionRepository> { DirectionRepositoryImpl(get()) }
    single<GradeRepository> { GradeRepositoryImpl(get()) }
    single<ApplicantRepository> { ApplicantRepositoryImpl(get()) }
}