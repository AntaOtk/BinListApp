package com.example.binlistapp.di

import com.example.binlistapp.damain.SearchingInteractor
import com.example.binlistapp.damain.SearchingInteractorImp
import com.example.binlistapp.damain.history.HistoryInteractor
import com.example.binlistapp.damain.history.HistoryInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<SearchingInteractor> {
        SearchingInteractorImp(get())
    }

    single<HistoryInteractor> {
        HistoryInteractorImpl(get())
    }
}
