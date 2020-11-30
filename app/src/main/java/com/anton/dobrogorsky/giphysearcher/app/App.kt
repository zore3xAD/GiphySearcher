package com.anton.dobrogorsky.giphysearcher.app

import android.app.Application
import com.anton.dobrogorsky.giphysearcher.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(
                listOf(
                    AppModules.giphy,
                    AppModules.viewModel,
                    AppModules.glide
                )
            )
            koin.createRootScope()
        }
    }

}