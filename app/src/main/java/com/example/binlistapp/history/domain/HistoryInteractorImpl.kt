package com.example.binlistapp.history.domain

import com.example.binlistapp.history.domain.model.FullCardInfo
import kotlinx.coroutines.flow.Flow

class HistoryInteractorImpl(
    val repository: HistoryRepository,
) : HistoryInteractor {

    override fun getHistory(): Flow<List<FullCardInfo>> {
        return repository.getHistory()
    }

    override suspend fun clearHistory() {
        repository.clearHistory()
    }
}