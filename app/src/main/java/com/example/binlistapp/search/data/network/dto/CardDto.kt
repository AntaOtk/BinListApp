package com.example.binlistapp.search.data.network.dto

data class CardDto(
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryDto,
    val bank: BankDto
): Response()