package com.example.spacexmavericks

import android.app.Application
import androidx.activity.ComponentActivity
import com.airbnb.mvrx.Mavericks
import com.example.spacexmavericks.dagger.AppComponent
import com.example.spacexmavericks.dagger.DaggerAppComponent

class MainApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        Mavericks.initialize(this)
    }
}

fun ComponentActivity.appComponent(): AppComponent {
    return (application as MainApplication).appComponent
}