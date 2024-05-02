package com.example.binlistapp.data

import android.content.Context
import com.example.binlistapp.damain.SearchingRepository
import com.example.binlistapp.damain.model.InfoData
import com.example.binlistapp.data.network.NetworkClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchingRepositoryImpl(val networkClient: NetworkClient, androidContext: Context) :
    SearchingRepository {
    override fun searchInfo(bin: String): Flow<InfoData> = flow {
        emit(InfoData("ds"))
    }
}
