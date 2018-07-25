package com.gravity.nobroker.injection.modules;

import com.gravity.nobroker.injection.scopes.ApplicationScope;
import com.gravity.nobroker.network.ApiHelperService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module(includes = [(NetworkModule::class)])
class ApiHelperServiceModule {

    @Provides
    @ApplicationScope
    fun getAppServiceHelper(retrofit: Retrofit): ApiHelperService {
        return retrofit.create(ApiHelperService::class.java)
    }

    @Provides
    @ApplicationScope
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://www.nobroker.in/api/v1/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}