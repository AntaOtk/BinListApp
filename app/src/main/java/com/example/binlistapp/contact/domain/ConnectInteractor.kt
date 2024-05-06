package com.example.binlistapp.contact.domain

interface ConnectInteractor {
    fun goToCall(phone: String)
    fun goToMap(latitude: Long, longitude: Long)
    fun goToUrl(bankUrl: String)
}