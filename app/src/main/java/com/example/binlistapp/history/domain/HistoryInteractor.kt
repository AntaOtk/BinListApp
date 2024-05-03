package com.example.binlistapp.history.domain

import com.example.binlistapp.search.domain.model.InfoData

interface HistoryInteractor {
    fun getHistory(): List<InfoData>
}