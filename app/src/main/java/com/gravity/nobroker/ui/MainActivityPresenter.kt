package com.gravity.nobroker.ui;

import com.gravity.nobroker.base.BasePresenter
import com.gravity.nobroker.network.ApiHelperService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Akash Verma on 24/07/18.
 */

class MainActivityPresenter @Inject constructor(apiServiceHelper: ApiHelperService,
                                                compositeDisposable: CompositeDisposable)
    : BasePresenter<MainActivityMvpView>(apiServiceHelper, compositeDisposable) {

    fun loadProperties(pageNo: Int) {
        if (pageNo == 0)
            mvpView!!.showLoading()
        getCompositeDisposableObject().add(getApiServiceHelper().getProperties(pageNo.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView!!.hideLoading()
                    if (it.statusCode == 200 && it.message.equals("success", true)) {
                        (mvpView as MainActivity).onDataFetched(it)
                    } else {
                        (mvpView as MainActivity).onError(it.message)
                    }
                }, {
                    mvpView!!.hideLoading()
                    (mvpView as MainActivity).onError(it.message.toString())
                }))
    }

    fun loadPropertiesWithFilters(pageNo: Int, type: String, buildingType: String, furnishing: String) {
        if (pageNo == 0)
            mvpView!!.showLoading()
        getCompositeDisposableObject().add(getApiServiceHelper()
                .getPropertiesWithFilter(pageNo.toString(), type, buildingType, furnishing)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView!!.hideLoading()
                    if (it.statusCode == 200 && it.message.equals("success", true)) {
                        (mvpView as MainActivity).onDataFetched(it)
                    } else {
                        (mvpView as MainActivity).onError(it.message)
                    }
                }, {
                    mvpView!!.hideLoading()
                    (mvpView as MainActivity).onError(it.message.toString())
                }))
    }

}