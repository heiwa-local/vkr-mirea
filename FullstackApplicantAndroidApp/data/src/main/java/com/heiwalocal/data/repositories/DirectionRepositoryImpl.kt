package com.heiwalocal.data.repositories

import com.heiwalocal.data.mappers.DirectionMapper
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Direction
import com.heiwalocal.domain.repositories.DirectionRepository

class DirectionRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): DirectionRepository {
    private val mapper = DirectionMapper()
    override fun getDirections(): List<Direction>? {
        return fullstackApiService.getDirections()?.items?.map {
            mapper.transform(it)
        }
    }
}