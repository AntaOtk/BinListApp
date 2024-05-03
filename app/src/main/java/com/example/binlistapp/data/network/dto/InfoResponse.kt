package com.example.binlistapp.data.network.dto

import com.example.binlistapp.damain.model.Bank

data class InfoResponse(
    val bank: Bank
) : Response()

