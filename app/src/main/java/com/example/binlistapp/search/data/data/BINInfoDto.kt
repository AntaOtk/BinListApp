package com.example.binlistapp.search.data.data

import com.example.binlistapp.search.domain.model.Bank

data class BINInfoDto(
    val scheme: String,
    val brand: String,
    val countryName: String,
    val bank: Bank
)