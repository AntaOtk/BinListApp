package com.example.binlistapp.search.data.mapper

import android.util.Log
import com.example.binlistapp.search.data.network.dto.BankDto
import com.example.binlistapp.search.data.network.dto.CardDto
import com.example.binlistapp.search.data.network.dto.CountryDto
import com.example.binlistapp.search.domain.model.Bank
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.domain.model.Country

class CardMapper {
    fun mapFromDto(card: CardDto): CardInfo? {
        val country = card.country?.let { mapToCountry(it) }
        val bank = card.bank?.let { mapToBank(it) }
        return if (
            card.scheme.isNullOrEmpty()
            && card.type.isNullOrEmpty()
            && card.brand.isNullOrEmpty()
            && country == null
            && bank == null
        ) null else {
            Log.d("Bank", "bank: $card")
            CardInfo(
                card.scheme ?: "",
                card.type ?: "",
                card.brand ?: "",
                card.prepaid,
                country,
                bank
            )
        }
    }

    private fun mapToBank(bank: BankDto): Bank? {
        return if (
            bank.name.isNullOrEmpty()
            && bank.url.isNullOrEmpty()
            && bank.phone.isNullOrEmpty()
            && bank.city.isNullOrEmpty()
        ) null else {
            Log.d("Bank", "bank: $bank")
            Bank(
                bank.name, bank.url, bank.phone, bank.city
            )
        }
    }

    private fun mapToCountry(country: CountryDto): Country? {
        return if (country.name.isNullOrEmpty() || country.latitude == null || country.longitude == null) null
        else Country(
            country.name, country.latitude, country.longitude
        )
    }
}