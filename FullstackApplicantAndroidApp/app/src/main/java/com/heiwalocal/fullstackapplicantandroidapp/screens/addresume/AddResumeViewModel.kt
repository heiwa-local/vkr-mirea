package com.heiwalocal.fullstackapplicantandroidapp.screens.addresume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Grade
import com.heiwalocal.domain.usecases.CreateResumeUseCase
import com.heiwalocal.domain.usecases.GetGradesUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddResumeViewModel(
    private val createResumeUseCase: CreateResumeUseCase,
    private val getGradesUseCase: GetGradesUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _grades = MutableLiveData<List<Grade>?>()
    val grade: LiveData<List<Grade>?>
        get() { return _grades }

    suspend fun createResume(
        jobTitle: String,
        salary: String,
        skills: String,
        education: String,
        workExperience: String,
        gradeId: String,
        address: String,
    ): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            createResumeUseCase.invoke(
                jobTitle= jobTitle,
                salary= salary,
                skills= skills,
                education= education,
                workExperience= workExperience,
                gradeId= gradeId,
                address= address,
            )
        }
    }

    fun getGrades() {
        launch (Dispatchers.IO + coroutineExceptionHandler) {
            _grades.postValue(
                getGradesUseCase.invoke()
            )
        }
    }
}