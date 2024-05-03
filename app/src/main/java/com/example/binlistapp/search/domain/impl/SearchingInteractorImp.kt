package com.example.binlistapp.search.domain.impl

import com.example.binlistapp.contact.domain.ExternalNavigator
import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.domain.SearchingRepository
import com.example.binlistapp.search.domain.model.InfoData
import kotlinx.coroutines.flow.Flow

class SearchingInteractorImp(private val repository: SearchingRepository, private val externalNavigator: ExternalNavigator):
    SearchingInteractor {

    override fun searchInfo(bin: String): Flow<InfoData> {
        return repository.searchInfo(bin)
    }

    override fun moveToCall(phone: String) {
        externalNavigator.moveToCall(phone)
    }

    override fun moveToMap(country: String) {
        externalNavigator.goToMAp(country)
    }

    override fun moveToUrl(bankUrl: String) {
        externalNavigator.goToBankUrl(bankUrl)
    }

}