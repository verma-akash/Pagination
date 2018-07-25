package com.gravity.nobroker.injection.component;

import com.gravity.nobroker.injection.modules.ActivityModule;
import com.gravity.nobroker.injection.scopes.ActivityScope;
import com.gravity.nobroker.ui.FilterActivity
import com.gravity.nobroker.ui.MainActivity;

import dagger.Component;

/**
 * Created by Akash Verma on 24/07/18.
 */

@ActivityScope
@Component(dependencies = [(ApplicationComponent::class)], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(filterActivity: FilterActivity)
}