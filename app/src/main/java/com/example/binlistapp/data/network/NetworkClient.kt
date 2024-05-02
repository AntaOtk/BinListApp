package com.example.binlistapp.data.network

import com.example.binlistapp.data.network.dto.INfoResponse

interface NetworkClient {
    suspend fun search(bin: String):INfoResponse
}