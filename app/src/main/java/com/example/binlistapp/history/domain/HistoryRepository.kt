package com.example.binlistapp.history.domain

import com.example.binlistapp.history.domain.model.FullCardInfo
import com.example.binlistapp.search.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun getHistory(): Flow<List<FullCardInfo>>
    suspend fun setToHistory(bin: String, cardInfo: CardInfo)
    suspend fun clearHistory()
}