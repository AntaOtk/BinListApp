package com.example.binlistapp.search.domain.impl

import com.example.binlistapp.contact.domain.ExternalNavigator
import com.example.binlistapp.history.domain.HistoryRepository
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.domain.SearchingRepository
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchingInteractorImp(
    private val repository: SearchingRepository,
    private val historyRepository: HistoryRepository,
    private val externalNavigator: ExternalNavigator
) :
    SearchingInteractor {

    override fun searchInfo(bin: String): Flow<Resource<CardInfo>> = flow {
        val result = repository.searchInfo(bin)
        if (result is Resource.Success) result.data?.let { historyRepository.setToHistory(bin,it) }
        emit(result)
    }

    override fun moveToCall(phone: String) {
        externalNavigator.goToCall(phone)
    }

    override fun moveToMap(country: String) {
        externalNavigator.goToMAp(country)
    }

    override fun moveToUrl(bankUrl: String) {
        externalNavigator.goToBankUrl(bankUrl)
    }

}