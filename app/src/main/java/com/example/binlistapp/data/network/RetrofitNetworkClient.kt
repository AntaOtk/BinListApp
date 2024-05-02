package com.example.binlistapp.data.network

import android.content.Context
import com.example.binlistapp.data.network.dto.INfoResponse

class RetrofitNetworkClient(val api: ApiSearchBIN,val context: Context): NetworkClient {
    override suspend fun search(bin: String): INfoResponse {
        return api.search(bin)
    }
}