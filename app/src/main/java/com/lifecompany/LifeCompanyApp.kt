package com.lifecompany

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.lifecompany.di.AppComponent
import timber.log.Timber

class LifeCompanyApp : Application() {

    private val appComponent: AppComponent by lazy { AppComponent.Initializer.init(this) }

    fun appComponent(): AppComponent = appComponent

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}