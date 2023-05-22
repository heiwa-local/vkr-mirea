package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Grade
import com.heiwalocal.domain.repositories.GradeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetGradesUseCase: KoinComponent {
    private val gradeRepository: GradeRepository by inject()

    operator fun invoke(): List<Grade>? {
        return gradeRepository.getGrades()
    }
}