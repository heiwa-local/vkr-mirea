package com.heiwalocal.fullstackapplicantandroidapp.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.heiwalocal.domain.usecases.GetVacanciesByKeywordsUseCase
import com.heiwalocal.fullstackapplicantandroidapp.screens.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.lang.reflect.Array.get

val viewModelsModule = module {
    viewModel { SearchViewModel(get()) }
}

val useCasesModule = module {
    single { GetVacanciesByKeywordsUseCase() }
}