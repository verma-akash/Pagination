package com.gravity.nobroker.injection.modules;

import android.content.Context;

import com.gravity.nobroker.injection.qualifiers.ApplicationContextQualifier;
import com.gravity.nobroker.injection.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class ContextModule {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    @Provides
    @ApplicationScope
    @ApplicationContextQualifier
    fun providesApplicationContext(): Context {
        return context
    }
}