package com.heiwalocal.fullstackapplicantandroidapp.screens.search

import com.heiwalocal.fullstackapplicantandroidapp.base.UiEvent
import com.heiwalocal.fullstackapplicantandroidapp.base.UiState

class SearchContract {
    sealed class SearchEvent: UiEvent {
        data class getVacanciesByKeywords(
            val keywords: String
        ): SearchEvent()
        object BackButtonPressed: SearchEvent()
    }

    data class SearchState(
        val isLoading: Boolean
    ): UiState {
        companion object {
            fun initial() = SearchState(
                isLoading = false
            )
        }
    }
}