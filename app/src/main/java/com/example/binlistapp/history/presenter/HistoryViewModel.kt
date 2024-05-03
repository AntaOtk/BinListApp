package com.example.binlistapp.history.presenter

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.binlistapp.history.domain.HistoryInteractor
import com.example.binlistapp.search.domain.model.InfoData

class HistoryViewModel(private val historyInteractor: HistoryInteractor) : ViewModel() {
    val listInfo = mutableStateListOf<InfoData>()

    fun getHistory() {
        historyInteractor.getHistory()
    }
}