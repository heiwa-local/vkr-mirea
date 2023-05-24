package com.heiwalocal.fullstackapplicantandroidapp

import android.app.Application
import com.heiwalocal.di.repositoriesModule
import com.heiwalocal.di.servicesModules
import com.heiwalocal.fullstackapplicantandroidapp.di.useCasesModule
import com.heiwalocal.fullstackapplicantandroidapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SampleApplication)

            modules(listOf(servicesModules, repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}