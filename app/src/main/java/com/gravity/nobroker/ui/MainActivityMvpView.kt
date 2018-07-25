package com.gravity.nobroker.ui;

import com.gravity.nobroker.base.MvpView;
import com.gravity.nobroker.models.Properties

/**
 * Created by Akash Verma on 24/07/18.
 */

interface MainActivityMvpView : MvpView {

    fun onDataFetched(properties: Properties)

    fun onError(errorMessage: String)
}
