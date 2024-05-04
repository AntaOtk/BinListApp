package com.example.binlistapp.di

import com.example.binlistapp.history.domain.HistoryRepository
import com.example.binlistapp.search.domain.SearchingRepository
import com.example.binlistapp.history.data.HistoryRepositoryImpl
import com.example.binlistapp.search.data.SearchingRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<SearchingRepository> {
        SearchingRepositoryImpl(get(),get(),androidContext())
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl(get(),get())
    }
}
