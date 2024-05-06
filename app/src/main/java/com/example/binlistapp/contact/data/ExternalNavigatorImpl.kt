package com.example.binlistapp.contact.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.binlistapp.R
import com.example.binlistapp.contact.domain.ExternalNavigator


class ExternalNavigatorImpl(private val context: Context) : ExternalNavigator {

    override fun goToCall(phone: String) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$phone")
        safeStartActivity(callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }

    override fun goToMAp(latitude: Long,longitude: Long) {
        val uri = Uri.parse("geo:0,0?q=$latitude,$longitude")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addCategory(Intent.CATEGORY_APP_MAPS)
        safeStartActivity(intent)
    }

    override fun goToBankUrl(bankUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = Uri.parse("https://$bankUrl")
        intent.addCategory(Intent.CATEGORY_APP_BROWSER)
        safeStartActivity(intent)
    }

    private fun safeStartActivity(intent: Intent) {
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                context.applicationContext,
                context.getString(R.string.error_action_view_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}