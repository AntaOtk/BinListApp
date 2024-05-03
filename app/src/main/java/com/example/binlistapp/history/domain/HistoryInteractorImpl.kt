package com.example.binlistapp.history.domain

import com.example.binlistapp.search.domain.model.InfoData

class HistoryInteractorImpl(val repository: HistoryRepository): HistoryInteractor {

    override fun getHistory(): List<InfoData>{
        return repository.getHistory()
    }
}