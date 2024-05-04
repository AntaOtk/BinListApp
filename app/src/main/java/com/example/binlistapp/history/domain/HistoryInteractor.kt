package com.example.binlistapp.history.domain

import com.example.binlistapp.history.domain.model.FullCardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryInteractor {
    fun getHistory(): Flow<List<FullCardInfo>>
    suspend fun clearHistory()
    fun goToCall(phone: String)
    fun goToMap(country: String)
    fun goToUrl(bankUrl: String)
}