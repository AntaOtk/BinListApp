package com.example.binlistapp.contact.domain

interface ExternalNavigator {
    fun goToCall(phone: String)
    fun goToMAp(latitude: Long,longitude: Long)
    fun goToBankUrl(bankUrl: String)
}