package com.gravity.nobroker.injection.modules;

import android.app.Activity;
import android.content.Context;
import com.gravity.nobroker.base.BaseActivity

import com.gravity.nobroker.injection.qualifiers.ActivityContextQualifier;
import com.gravity.nobroker.injection.scopes.ActivityScope

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class ActivityModule {

    private val context: BaseActivity

    constructor(context: BaseActivity) {
        this.context = context
    }

    @Provides
    @ActivityScope
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    @ActivityContextQualifier
    fun providesActivityContext(): BaseActivity {
        return context
    }
}