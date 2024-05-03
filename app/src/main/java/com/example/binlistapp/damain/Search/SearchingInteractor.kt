package com.example.binlistapp.damain.Search

import com.example.binlistapp.damain.model.InfoData
import kotlinx.coroutines.flow.Flow

interface SearchingInteractor {
    fun searchInfo(bin: String): Flow<InfoData>
}
