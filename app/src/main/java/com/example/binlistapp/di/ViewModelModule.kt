package com.example.binlistapp.di


import com.example.binlistapp.ui.MainActivityViewModel
import com.example.binlistapp.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        SearchViewModel(get())
    }
    viewModel { MainActivityViewModel() }

}
