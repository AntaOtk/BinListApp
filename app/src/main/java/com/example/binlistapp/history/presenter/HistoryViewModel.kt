package com.example.binlistapp.history.presenter

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.contact.ToConnectProvider
import com.example.binlistapp.history.domain.HistoryInteractor
import com.example.binlistapp.history.domain.model.FullCardInfo
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyInteractor: HistoryInteractor) : ViewModel(), ToConnectProvider {
    val listInfo = mutableStateListOf<FullCardInfo>()

    fun getHistory() {
        viewModelScope.launch {
            historyInteractor.getHistory().collect { historyList ->
                listInfo.clear()
                listInfo.addAll(historyList)
            }
        }
    }

    fun cleanHistory() {
        viewModelScope.launch {
            historyInteractor.clearHistory()
            getHistory()
        }
    }

    override fun goToCall(phone: String) {
        historyInteractor.goToCall(phone)
    }

    override fun goToMap(latitude: Long, longitude: Long) {
        historyInteractor.goToMap(latitude, longitude)
    }

    override fun goToUrl(bankUrl: String) {
        historyInteractor.goToUrl(bankUrl)
    }
}