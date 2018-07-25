package com.gravity.nobroker.injection.component;

import com.bumptech.glide.RequestManager;
import com.gravity.nobroker.NoBrokerApplication;
import com.gravity.nobroker.injection.modules.ApiHelperServiceModule;
import com.gravity.nobroker.injection.modules.GlideModule;
import com.gravity.nobroker.injection.scopes.ApplicationScope;
import com.gravity.nobroker.network.ApiHelperService;

import dagger.Component;

/**
 * Created by Akash Verma on 24/07/18.
 */

@ApplicationScope
@Component(modules = [(ApiHelperServiceModule::class), (GlideModule::class)])
interface ApplicationComponent {

    fun getApiServiceHelper(): ApiHelperService

    fun getGlideRequestManager(): RequestManager
}
