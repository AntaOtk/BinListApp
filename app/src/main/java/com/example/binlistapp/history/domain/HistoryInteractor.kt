package com.example.binlistapp.history.domain

import com.example.binlistapp.search.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryInteractor {
    fun getHistory(): Flow<List<CardInfo>>
    suspend fun clearHistory()
    fun goToCall(phone: String)
    fun goToMap(country: String)
    fun goToUrl(bankUrl: String)
}