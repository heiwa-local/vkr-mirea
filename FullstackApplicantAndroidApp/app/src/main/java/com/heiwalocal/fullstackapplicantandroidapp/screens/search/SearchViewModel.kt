package com.heiwalocal.fullstackapplicantandroidapp.screens.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Direction
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.usecases.GetDirectionsUseCase
import com.heiwalocal.domain.usecases.GetVacanciesByKeywordsUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.*

class SearchViewModel(
    private val getVacanciesByKeywordsUseCase: GetVacanciesByKeywordsUseCase,
    private val getDirectionsUseCase: GetDirectionsUseCase
): BaseViewModel() {

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _vacancies = MutableLiveData<List<Vacancy>?>()
    val vacancy: LiveData<List<Vacancy>?>
        get() { return _vacancies }

    private val _directions = MutableLiveData<List<Direction>?>()
    val directions: LiveData<List<Direction>?>
        get() { return _directions }

    fun getVacanciesByKeywords(
        keywords: String,
        type: String?,
        salary: String?,
        tags: String?
    ) = launch(Dispatchers.IO + coroutineExceptionHandler) {
        _vacancies.postValue(
            getVacanciesByKeywordsUseCase.invoke(
                keywords = keywords,
                type = type,
                salary = salary,
                tags = tags
            )
        )
    }

    fun getDirections() {
         launch(Dispatchers.IO + coroutineExceptionHandler) {
            _directions.postValue(
                getDirectionsUseCase.invoke()
            )
        }
    }
}