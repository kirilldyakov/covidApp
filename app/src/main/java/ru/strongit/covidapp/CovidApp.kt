package ru.strongit.covidapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.strongit.covidapp.di.appComponent


class CovidApp : Application() {

    override fun onCreate() {
        super.onCreate()

        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CovidApp)
            modules(provideComponent())
        }
    }

    private fun provideComponent() = appComponent
}