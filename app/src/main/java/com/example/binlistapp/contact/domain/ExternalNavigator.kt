package com.example.binlistapp.contact.domain

interface ExternalNavigator {
    fun moveToCall(phone: String)
    fun goToMAp(city: String)
    fun goToBankUrl(bankUrl: String)
}