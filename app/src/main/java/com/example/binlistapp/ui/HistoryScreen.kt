package com.example.binlistapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.binlistapp.damain.model.InfoData

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = viewModel(), modifier: Modifier) {
    ListOfInfo(viewModel.listInfo, modifier)
}

@Composable
fun ListOfInfo(items: List<InfoData>, modifier: Modifier) {
    Column { items.forEach { InfoPresenter(it, modifier) } }
}
