package com.example.binlistapp.search.data.network.dto

import com.example.binlistapp.search.domain.model.Bank

data class InfoResponse(
    val bank: Bank
) : Response()

