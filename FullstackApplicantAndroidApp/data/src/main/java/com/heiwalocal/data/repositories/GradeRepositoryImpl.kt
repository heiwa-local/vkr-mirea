package com.heiwalocal.data.repositories

import com.heiwalocal.data.mappers.GradeMapper
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Grade
import com.heiwalocal.domain.repositories.GradeRepository

class GradeRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): GradeRepository {
    private val mapper = GradeMapper()

    override fun getGrades(): List<Grade>? {
        return fullstackApiService.getGrades()?.items?.map { mapper.transform(it) }
    }
}