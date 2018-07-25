package com.gravity.nobroker.base;

/**
 * Created by Akash Verma on 24/07/18.
 */

interface MvpPresenter<in V : MvpView> {

    fun onAttach(view: V)

    fun onDetach()
}