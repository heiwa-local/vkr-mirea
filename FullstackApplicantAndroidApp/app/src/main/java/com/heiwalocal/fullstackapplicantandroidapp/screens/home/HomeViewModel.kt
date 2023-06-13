package com.heiwalocal.fullstackapplicantandroidapp.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.usecases.GetLastAddedVacanciesUseCase
import com.heiwalocal.domain.usecases.GetRecommendedVacanciesUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getLastAddedVacanciesUseCase: GetLastAddedVacanciesUseCase,
    private val getRecommendedVacanciesUseCase: GetRecommendedVacanciesUseCase,
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _recommendedVacancies = MutableLiveData<List<Vacancy>?>()
    val recommendedVacancies: LiveData<List<Vacancy>?>
        get() { return _recommendedVacancies }

    private val _lastAddedVacancies = MutableLiveData<List<Vacancy>?>()
    val lastAddedVacancies: LiveData<List<Vacancy>?>
        get() { return _lastAddedVacancies }

    suspend fun getRecommendedVacancies() = withContext(Dispatchers.IO + coroutineExceptionHandler) {
        _recommendedVacancies.postValue(
            getRecommendedVacanciesUseCase.invoke()
        )
    }

    suspend fun getLastAddedVacancies() = withContext(Dispatchers.IO + coroutineExceptionHandler) {
        _lastAddedVacancies.postValue(
            getLastAddedVacanciesUseCase.invoke()
        )
    }
}