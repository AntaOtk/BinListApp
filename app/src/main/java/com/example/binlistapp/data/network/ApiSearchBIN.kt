package com.example.binlistapp.data.network

import com.example.binlistapp.data.network.dto.INfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSearchBIN {

    @GET
    suspend fun search(@Query("text") text: String): INfoResponse
}