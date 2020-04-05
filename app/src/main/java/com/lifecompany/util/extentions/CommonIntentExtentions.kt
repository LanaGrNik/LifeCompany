package com.lifecompany.util.extentions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes
import com.lifecompany.R

fun Activity.openUrl(url: String) {
    val link = if(url.contains("http")) url else "http://$url"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    launchIntent(intent, R.string.intent_error_no_browser)
}

fun Activity.callPhone(telephone: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse(URI_TELEPHONE_PREFIX + telephone)
    launchIntent(intent, R.string.intent_error_no_caller)
}

fun Context.launchIntent(
    intent: Intent,
    @StringRes errorMessage: Int
) {
    if (canLaunchIntent(intent)) {
        startActivity(intent, null)
    } else {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}

private fun Context.canLaunchIntent(intent: Intent): Boolean {
    val infos = packageManager.queryIntentActivities(intent, 0)
    return !infos.isNullOrEmpty()
}

private const val URI_TELEPHONE_PREFIX = "tel:"