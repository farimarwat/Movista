package com.farimarwat.movista.android

import android.app.Application
import com.farimarwat.movista.android.di.appModules
import com.farimarwat.movista.di.initKoin
import com.farimarwat.movista.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidContext(this@BaseApplication)
            modules(sharedModule+ appModules)
        }
    }
}