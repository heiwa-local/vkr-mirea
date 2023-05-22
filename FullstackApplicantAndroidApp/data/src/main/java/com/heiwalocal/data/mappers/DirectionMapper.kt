package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.DirectionResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Direction

class DirectionMapper: BaseMapper<DirectionResponse, Direction> {
    override fun transform(type: DirectionResponse): Direction {
        return Direction(
            id = type.id,
            name = type.name
        )
    }

    override fun transformToRepository(type: Direction): DirectionResponse {
        TODO("Not yet implemented")
    }
}