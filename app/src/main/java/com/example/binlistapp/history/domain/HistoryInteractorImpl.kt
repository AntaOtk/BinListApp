package com.example.binlistapp.history.domain

import com.example.binlistapp.contact.domain.ExternalNavigator
import com.example.binlistapp.history.domain.model.FullCardInfo
import kotlinx.coroutines.flow.Flow

class HistoryInteractorImpl(
    val repository: HistoryRepository,
    private val externalNavigator: ExternalNavigator
) : HistoryInteractor {

    override fun getHistory(): Flow<List<FullCardInfo>> {
        return repository.getHistory()
    }

    override suspend fun clearHistory() {
        repository.clearHistory()
    }

    override fun goToCall(phone: String) {
        externalNavigator.goToCall(phone)
    }

    override fun goToMap(country: String) {
        externalNavigator.goToMAp(country)

    }

    override fun goToUrl(bankUrl: String) {
        externalNavigator.goToBankUrl(bankUrl)
    }
}