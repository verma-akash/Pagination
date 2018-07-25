package com.gravity.nobroker.ui

import com.gravity.nobroker.base.BasePresenter
import com.gravity.nobroker.network.ApiHelperService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akash Verma on 25/07/18.
 */
class FilterPresenter @Inject constructor(apiServiceHelper: ApiHelperService,
                                          compositeDisposable: CompositeDisposable)
    : BasePresenter<FilterMvpView>(apiServiceHelper, compositeDisposable) {


}