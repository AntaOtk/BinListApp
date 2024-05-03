package com.example.binlistapp.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.binlistapp.damain.model.InfoData

class HistoryViewModel() : ViewModel() {
    val listInfo = mutableStateListOf<InfoData>()
}