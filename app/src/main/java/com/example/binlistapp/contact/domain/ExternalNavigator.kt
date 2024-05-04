package com.example.binlistapp.contact.domain

interface ExternalNavigator {
    fun goToCall(phone: String)
    fun goToMAp(city: String)
    fun goToBankUrl(bankUrl: String)
}