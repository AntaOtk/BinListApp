package com.example.binlistapp.search.data

import android.content.Context
import android.util.Log
import com.example.binlistapp.R
import com.example.binlistapp.search.data.mapper.CardMapper
import com.example.binlistapp.search.data.network.NetworkClient
import com.example.binlistapp.search.data.network.dto.CardDto
import com.example.binlistapp.search.domain.SearchingRepository
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.util.Resource

class SearchingRepositoryImpl(
    private val networkClient: NetworkClient,
    private val mapper: CardMapper,
    private val androidContext: Context
) :
    SearchingRepository {
    override suspend fun searchInfo(bin: String): Resource<CardInfo> {
        val response = networkClient.search(bin)
        when (response.resultCode) {
            -1 -> {
                return Resource.Error(androidContext.getString(R.string.no_interrnet_conection))
            }

            200 -> {
                with(response as CardDto) {
                    Log.d("response", "result = $this")
                    val data = mapper.mapFromDto(this)
                    return if (data != null) Resource.Success(data)
                    else Resource.Error(
                        androidContext.getString(R.string.not_found)
                    )
                }
            }

            else -> {
                return Resource.Error(androidContext.getString(R.string.bad_response))
            }
        }
    }
}
