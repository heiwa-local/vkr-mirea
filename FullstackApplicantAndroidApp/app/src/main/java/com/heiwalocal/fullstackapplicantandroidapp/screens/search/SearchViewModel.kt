package com.heiwalocal.fullstackapplicantandroidapp.screens.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.heiwalocal.domain.repositories.VacancyRepository
import com.heiwalocal.domain.usecases.GetVacanciesByKeywordsUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getVacanciesByKeywordsUseCase: GetVacanciesByKeywordsUseCase
): BaseViewModel<SearchContract.SearchEvent, SearchContract.SearchState>() {

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    override fun createInitialState(): SearchContract.SearchState {
        return SearchContract.SearchState(isLoading = false)
    }

    override fun handleEvent(event: SearchContract.SearchEvent) {
        when (event) {
            is SearchContract.SearchEvent.getVacanciesByKeywords -> {
                getVacanciesByKeywords("asd")
            }
        }
    }

    fun getVacanciesByKeywords(keywords: String) = launch(Dispatchers.IO + coroutineExceptionHandler) {
        Log.e("aaa", getVacanciesByKeywordsUseCase.invoke("asd")?.count.toString())
    }
}