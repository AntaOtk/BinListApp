package com.example.binlistapp.damain

import com.example.binlistapp.damain.model.InfoData
import kotlinx.coroutines.flow.Flow

class SearchingInteractorImp(val repository: SearchingRepository):SearchingInteractor {

    override fun searchInfo(bin: String): Flow<InfoData> {
        return repository.searchInfo(bin)
    }

}