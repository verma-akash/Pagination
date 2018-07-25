package com.gravity.nobroker.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gravity.nobroker.NoBrokerApplication;
import com.gravity.nobroker.injection.component.ActivityComponent;
import com.gravity.nobroker.injection.component.DaggerActivityComponent;
import com.gravity.nobroker.injection.modules.ActivityModule;

/**
 * Created by Akash Verma on 24/07/18.
 */

abstract class BaseActivity : AppCompatActivity(), MvpView {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(NoBrokerApplication.get(this).getComponent())
                .build()

    }

    fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }
}
