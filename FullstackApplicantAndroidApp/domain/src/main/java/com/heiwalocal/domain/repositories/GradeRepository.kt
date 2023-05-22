package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Grade

interface GradeRepository {
    fun getGrades(): List<Grade>?
}