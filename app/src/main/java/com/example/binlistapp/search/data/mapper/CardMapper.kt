package com.example.binlistapp.search.data.mapper

import com.example.binlistapp.search.data.network.dto.BankDto
import com.example.binlistapp.search.data.network.dto.CardDto
import com.example.binlistapp.search.data.network.dto.CountryDto
import com.example.binlistapp.search.domain.model.Bank
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.domain.model.Country

class CardMapper {
    fun mapFromDto(card: CardDto): CardInfo {
        return CardInfo(
            card.scheme ?: "",
            card.type ?: "",
            card.brand ?: "",
            card.prepaid,
            mapToCountry(card.country),
            mapToBank(card.bank)
        )
    }

    private fun mapToBank(bank: BankDto): Bank {
        return Bank(
            bank.name,
            bank.url,
            bank.phone,
            bank.city
        )

    }

    private fun mapToCountry(country: CountryDto): Country {
        return Country(
            country.name,
            country.latitude,
            country.longitude
        )
    }
}