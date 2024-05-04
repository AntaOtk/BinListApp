package com.example.binlistapp.history.domain.model

import com.example.binlistapp.search.domain.model.Bank
import com.example.binlistapp.search.domain.model.Country

data class FullCardInfo(
    val bin: String,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Country?,
    val bank: Bank?
)
