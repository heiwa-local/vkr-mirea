package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Direction
import com.heiwalocal.domain.repositories.DirectionRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetDirectionsUseCase: KoinComponent {
    private val directionRepository: DirectionRepository by inject()

    operator fun invoke(): List<Direction>? {
        return directionRepository.getDirections()
    }
}