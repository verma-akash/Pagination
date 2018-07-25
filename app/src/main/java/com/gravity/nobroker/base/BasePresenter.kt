package com.gravity.nobroker.base;

import com.gravity.nobroker.network.ApiHelperService;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Akash Verma on 24/07/18.
 */

open class BasePresenter<in V : MvpView> : MvpPresenter<V> {

    var mvpView: MvpView? = null
    private val compositeDisposable: CompositeDisposable
    private val apiServiceHelper: ApiHelperService

    @Inject
    constructor(apiServiceHelper: ApiHelperService, compositeDisposable: CompositeDisposable) {
        this.apiServiceHelper = apiServiceHelper
        this.compositeDisposable = compositeDisposable
    }

    override fun onAttach(view: V) {
        mvpView = view
    }

    override fun onDetach() {
        mvpView = null
        compositeDisposable.dispose()
    }

    fun getCompositeDisposableObject(): CompositeDisposable {
        return compositeDisposable
    }

    fun getApiServiceHelper(): ApiHelperService {
        return apiServiceHelper
    }

}