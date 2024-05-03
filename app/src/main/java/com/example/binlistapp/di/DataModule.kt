package com.example.binlistapp.di

import android.content.Context
import androidx.room.Room
import com.example.binlistapp.contact.domain.ExternalNavigator
import com.example.binlistapp.contact.data.ExternalNavigatorImpl
import com.example.binlistapp.history.data.bd.AppDatabase
import com.example.binlistapp.search.data.network.ApiSearchBIN
import com.example.binlistapp.search.data.network.NetworkClient
import com.example.binlistapp.search.data.network.RetrofitNetworkClient
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single<ApiSearchBIN> {
        Retrofit.Builder().baseUrl("https://lookup.binlist.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSearchBIN::class.java)
    }

    single {
        androidContext()
            .getSharedPreferences("local_storage", Context.MODE_PRIVATE)
    }

    factory { Gson() }

    single<NetworkClient> {
        RetrofitNetworkClient(get(), androidContext())
    }

    single<ExternalNavigator> {
        ExternalNavigatorImpl(androidContext())
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db")
            .build()
    }

    single {
        val database = get<AppDatabase>()
        database.infoDao()
    }
}
