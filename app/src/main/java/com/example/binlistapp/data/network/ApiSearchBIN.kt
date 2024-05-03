package com.example.binlistapp.data.network

import com.example.binlistapp.data.network.dto.InfoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiSearchBIN {

    @GET("/{text}")
    suspend fun search(@Path("text") text: String): InfoResponse
}