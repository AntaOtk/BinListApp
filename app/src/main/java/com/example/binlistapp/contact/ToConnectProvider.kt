package com.example.binlistapp.contact

interface ToConnectProvider {
    fun goToCall(phone: String)

    fun goToMap(latitude: Long, longitude: Long)

    fun goToUrl(bankUrl: String)
}
