package com.example.binlistapp.data.contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.binlistapp.damain.ExternalNavigator

class ExternalNavigatorImpl(private val context: Context) : ExternalNavigator {

    override fun sharePhone(phone: String) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phone")
        context.startActivity(callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    override fun goToMAp(city: String) {
    }

    override fun goToBankUrl(bankUrl: String) {
    }
}