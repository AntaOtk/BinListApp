package com.example.binlistapp.search.domain

import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.util.Resource
import kotlinx.coroutines.flow.Flow

interface SearchingInteractor {
    fun searchInfo(bin: String): Flow<Resource<CardInfo>>
}
