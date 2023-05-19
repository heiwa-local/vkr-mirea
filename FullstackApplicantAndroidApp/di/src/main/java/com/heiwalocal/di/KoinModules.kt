package com.heiwalocal.di

import com.heiwalocal.data.remote.fullstackapi.FullstackApiService
import com.heiwalocal.data.repositories.VacancyRepositoryImpl
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single { FullstackApiService() }

    single<VacancyRepository> { VacancyRepositoryImpl(get()) }
}