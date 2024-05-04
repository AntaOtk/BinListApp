package com.example.binlistapp.history.presenter

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.history.domain.HistoryInteractor
import com.example.binlistapp.search.domain.model.CardInfo
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyInteractor: HistoryInteractor) : ViewModel() {
    val listInfo = mutableStateListOf<CardInfo>()

    fun getHistory() {
        viewModelScope.launch {
            historyInteractor.getHistory().collect { historyList ->
                listInfo.clear()
                listInfo.addAll(historyList)
            }
        }
    }

    fun cleanHistory() {

    }

    fun goToCall(phone: String) {
        historyInteractor.goToCall(phone)
    }

    fun goToMap(country: String) {
        historyInteractor.goToMap(country)
    }

    fun goToUrl(bankUrl: String) {
        historyInteractor.goToUrl(bankUrl)
    }
}