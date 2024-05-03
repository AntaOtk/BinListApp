package com.example.binlistapp.data.network

import com.example.binlistapp.data.network.dto.Response

interface NetworkClient {
    suspend fun search(bin: String): Response
}