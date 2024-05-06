package com.example.binlistapp.di


import com.example.binlistapp.history.presentation.HistoryViewModel
import com.example.binlistapp.search.presentation.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SearchViewModel(get(),get(),androidContext())
    }
    viewModel {
        HistoryViewModel(get(),get())
    }

}
