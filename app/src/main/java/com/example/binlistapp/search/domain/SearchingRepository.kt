package com.example.binlistapp.search.domain

import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.util.Resource

interface SearchingRepository {
    suspend fun searchInfo(bin: String): Resource<CardInfo>
}
