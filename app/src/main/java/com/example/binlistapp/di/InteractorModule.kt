package com.example.binlistapp.di

import com.example.binlistapp.search.domain.SearchingInteractor
import com.example.binlistapp.search.domain.impl.SearchingInteractorImp
import com.example.binlistapp.history.domain.HistoryInteractor
import com.example.binlistapp.history.domain.HistoryInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<SearchingInteractor> {
        SearchingInteractorImp(get(),get(),get())
    }

    single<HistoryInteractor> {
        HistoryInteractorImpl(get(),get())
    }
}
