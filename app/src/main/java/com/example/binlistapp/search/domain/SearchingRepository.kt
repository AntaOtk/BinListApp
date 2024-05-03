package com.example.binlistapp.search.domain

import com.example.binlistapp.search.domain.model.InfoData
import kotlinx.coroutines.flow.Flow

interface SearchingRepository {
    fun searchInfo(bin: String): Flow<InfoData>
}
