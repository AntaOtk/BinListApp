package com.example.binlistapp.contact.domain.impl

import com.example.binlistapp.contact.domain.ConnectInteractor
import com.example.binlistapp.contact.domain.ExternalNavigator

class ConnectInteractorImpl(private val externalNavigator: ExternalNavigator): ConnectInteractor {

    override fun goToCall(phone: String) {
        externalNavigator.goToCall(phone)
    }

    override fun goToMap(latitude: Long,longitude: Long) {
        externalNavigator.goToMAp(latitude,longitude)
    }

    override fun goToUrl(bankUrl: String) {
        externalNavigator.goToBankUrl(bankUrl)
    }
}