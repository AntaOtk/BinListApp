package com.example.binlistapp.search.data

import android.content.Context
import com.example.binlistapp.search.domain.SearchingRepository
import com.example.binlistapp.search.domain.model.Bank
import com.example.binlistapp.search.domain.model.InfoData
import com.example.binlistapp.search.data.network.NetworkClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchingRepositoryImpl(val networkClient: NetworkClient, androidContext: Context) :
    SearchingRepository {
    override fun searchInfo(bin: String): Flow<InfoData> = flow {
        emit(InfoData("","","Russia", Bank("ddd", "www.jyskebank.dk", "2123322", "")))
    }
}
