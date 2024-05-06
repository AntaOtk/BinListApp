package com.example.binlistapp.history.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.contact.domain.ConnectInteractor
import com.example.binlistapp.contact.presentation.ToConnectProvider
import com.example.binlistapp.history.domain.HistoryInteractor
import com.example.binlistapp.history.domain.model.FullCardInfo
import kotlinx.coroutines.launch

class HistoryViewModel(private val historyInteractor: HistoryInteractor, private val connectInteractor: ConnectInteractor) : ViewModel(),
    ToConnectProvider {
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
        connectInteractor.goToCall(phone)
    }

    override fun goToMap(latitude: Long, longitude: Long) {
        connectInteractor.goToMap(latitude, longitude)
    }

    override fun goToUrl(bankUrl: String) {
        connectInteractor.goToUrl(bankUrl)
    }
}