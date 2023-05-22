package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Direction

interface DirectionRepository {
    fun getDirections(): List<Direction>?
}