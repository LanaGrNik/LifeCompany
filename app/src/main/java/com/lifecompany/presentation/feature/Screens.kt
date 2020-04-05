package com.lifecompany.presentation.feature

import android.content.Context
import android.content.Intent
import com.lifecompany.presentation.feature.companydetails.CompanyDetailsActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class CompanyDetailsScreen(private val id: Int): SupportAppScreen() {
        override fun getActivityIntent(context: Context) = CompanyDetailsActivity.getIntent(context, id)
    }
}