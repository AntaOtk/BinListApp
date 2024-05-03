package com.example.binlistapp.di

import android.content.Context
import com.example.binlistapp.data.network.ApiSearchBIN
import com.example.binlistapp.data.network.NetworkClient
import com.example.binlistapp.data.network.RetrofitNetworkClient
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
}
