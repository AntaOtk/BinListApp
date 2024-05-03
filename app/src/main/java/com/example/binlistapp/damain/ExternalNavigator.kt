package com.example.binlistapp.damain

interface ExternalNavigator {
    fun sharePhone(phone: String)
    fun goToMAp(city: String)
    fun goToBankUrl(bankUrl: String)
}