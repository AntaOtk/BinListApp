package com.example.binlistapp.history.domain

import com.example.binlistapp.search.domain.model.CardInfo
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    fun getHistory(): Flow<List<CardInfo>>
    suspend fun setToHistory(cardInfo: CardInfo)
    suspend fun clearHistory()
}