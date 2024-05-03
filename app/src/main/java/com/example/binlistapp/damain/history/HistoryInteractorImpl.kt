package com.example.binlistapp.damain.history

class HistoryInteractorImpl(val repository: HistoryRepository):HistoryInteractor {

    fun getHistory(){
        repository.getHistory()
    }
}