package com.example.binlistapp.search.data.network

import com.example.binlistapp.search.data.network.dto.Response

interface NetworkClient {
    suspend fun search(bin: String): Response
}