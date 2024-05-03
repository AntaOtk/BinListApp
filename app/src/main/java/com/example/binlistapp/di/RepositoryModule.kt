package com.example.binlistapp.di

import com.example.binlistapp.damain.history.HistoryRepository
import com.example.binlistapp.damain.Search.SearchingRepository
import com.example.binlistapp.data.history.HistoryRepositoryImpl
import com.example.binlistapp.data.SearchingRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<SearchingRepository> {
        SearchingRepositoryImpl(get(),androidContext())
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl()
    }
}
