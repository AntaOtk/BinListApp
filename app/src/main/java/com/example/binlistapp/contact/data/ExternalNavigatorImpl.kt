package com.example.binlistapp.contact.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.binlistapp.contact.domain.ExternalNavigator


class ExternalNavigatorImpl(private val context: Context) : ExternalNavigator {

    override fun moveToCall(phone: String) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phone")
        context.startActivity(callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    override fun goToMAp(city: String) {
        val uri = Uri.parse("geo:0,0?q=$city")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    }

    override fun goToBankUrl(bankUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("https://$bankUrl")
        context.startActivity(intent)

    }
}