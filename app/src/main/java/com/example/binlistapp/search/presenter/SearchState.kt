package com.example.binlistapp.search.presenter

import com.example.binlistapp.search.domain.model.CardInfo

sealed interface SearchState {

    object Default: SearchState
    data class Content(
        val cardInfo: CardInfo
    ) : SearchState
    data class Error(
        val errorMessage: String
    ) : SearchState
}