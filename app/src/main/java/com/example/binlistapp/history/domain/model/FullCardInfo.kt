package com.example.binlistapp.history.domain.model

import com.example.binlistapp.search.domain.model.CardInfo

data class FullCardInfo(
    val bin: String,
    val cardInfo: CardInfo
)
