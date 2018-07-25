package com.gravity.nobroker;

import android.app.Activity;
import android.app.Application;

import com.gravity.nobroker.injection.component.ApplicationComponent;
import com.gravity.nobroker.injection.component.DaggerApplicationComponent;
import com.gravity.nobroker.injection.modules.ContextModule;

/**
 * Created by Akash Verma on 24/07/18.
 */

class NoBrokerApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun get(activity: Activity): NoBrokerApplication {
            return activity.application as NoBrokerApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(ContextModule(this))
                .build()

    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}