package com.example.binlistapp.search.domain

import com.example.binlistapp.search.domain.model.InfoData
import kotlinx.coroutines.flow.Flow

interface SearchingInteractor {
    fun searchInfo(bin: String): Flow<InfoData>

    fun moveToCall(phone: String)
    fun moveToMap(country: String)
    fun moveToUrl(bankUrl: String)
}
