package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.GradeResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Grade

class GradeMapper: BaseMapper<GradeResponse, Grade> {
    override fun transform(type: GradeResponse): Grade {
        return Grade(
            id = type.id,
            name = type.name
        )
    }

    override fun transformToRepository(type: Grade): GradeResponse {
        TODO("Not yet implemented")
    }
}