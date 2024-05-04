package com.example.binlistapp.history.data.mapper

import com.example.binlistapp.history.data.bd.entity.BINInfoEntity
import com.example.binlistapp.history.domain.model.FullCardInfo
import com.example.binlistapp.search.domain.model.Bank
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.domain.model.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CardInfoBdMapper(private val gson: Gson) {
    fun map(cardInfo: BINInfoEntity): FullCardInfo {
        return FullCardInfo(
            cardInfo.id.toString(),
            CardInfo(cardInfo.scheme,
            cardInfo.type,
            cardInfo.brand,
            cardInfo.prepaid,
            mapToCountry(cardInfo.country),
            mapToBank(cardInfo.bank))
        )
    }

    fun map(bin: String, cardInfo: CardInfo): BINInfoEntity {
        return BINInfoEntity(
            bin.toLong(),
            cardInfo.scheme,
            cardInfo.type,
            cardInfo.brand,
            cardInfo.prepaid,
            gson.toJson(cardInfo.country),
            gson.toJson(cardInfo.bank),
        )
    }

    private fun mapToBank(bank: String): Bank? {
        val listOfMyClassObject: Type = object : TypeToken<Bank?>() {}.type
        return if (bank.isNotEmpty()) gson.fromJson(bank, listOfMyClassObject) else null
    }

    private fun mapToCountry(country: String): Country? {
        val listOfMyClassObject: Type = object : TypeToken<Country?>() {}.type
        return if (country.isNotEmpty()) gson.fromJson(country, listOfMyClassObject) else null
    }
}
