package com.example.binlistapp.search.domain.model

data class CardInfo(
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank?
)
