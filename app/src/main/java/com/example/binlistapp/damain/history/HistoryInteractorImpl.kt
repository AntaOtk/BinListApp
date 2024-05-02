package com.example.binlistapp.damain.history

import com.example.binlistapp.damain.HistoryRepository

class HistoryInteractorImpl(val repository: HistoryRepository):HistoryInteractor {

    fun getHistory(){
        repository.getHistory()
    }
}