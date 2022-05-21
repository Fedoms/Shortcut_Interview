package org.meeters.xkcd.application

import android.app.Application
import org.meeters.xkcd.repository.MainRepositoryImpl

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MainRepositoryImpl().apply {
             // inject here the appModule so the Repository does not die
        }
    }
}