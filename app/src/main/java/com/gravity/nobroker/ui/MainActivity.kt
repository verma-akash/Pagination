package com.gravity.nobroker.ui;

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.gravity.nobroker.AppConstants
import com.gravity.nobroker.CommonUtil
import com.gravity.nobroker.R
import com.gravity.nobroker.base.BaseActivity
import com.gravity.nobroker.models.Datum
import com.gravity.nobroker.models.Properties
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Akash Verma on 24/07/18.
 */

class MainActivity : BaseActivity(), MainActivityMvpView, PropertiesAdapter.AdapterListener {

    private val FILTER_REQUEST = 100

    @Inject
    lateinit var propertiesAdapter: PropertiesAdapter

    private val propertiesArrayList = ArrayList<Datum>()

    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter

    private var isFilterApplied = false

    private var ap_filter = ""
    private var building_filter = ""
    private var furnishing_filter = ""
    private var dataLeft = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)

        mainActivityPresenter.onAttach(this)

        propertiesAdapter.setPropertiesArrayList(propertiesArrayList)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = propertiesAdapter

        if (CommonUtil.isNetworkConnected(this))
            mainActivityPresenter.loadProperties(PAGE_NUMBER++)
        else
            showNetworkDialog()

        filterFab.setOnClickListener {
            var intent = Intent(this@MainActivity, FilterActivity::class.java)
            if (isFilterApplied) {
                intent.putExtra(AppConstants.AP_FILTER, ap_filter)
                intent.putExtra(AppConstants.BUILDING_FILTER, building_filter)
                intent.putExtra(AppConstants.FURNISHING_FILTER, furnishing_filter)
            }
            startActivityForResult(intent, FILTER_REQUEST)
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        mainActivityPresenter.onDetach()
        super.onDestroy()
    }

    override fun loadData() {
        if (dataLeft) {
            if (CommonUtil.isNetworkConnected(this)) {
                loadMoreContainer.visibility = View.VISIBLE

                if (!isFilterApplied)
                    mainActivityPresenter.loadProperties(PAGE_NUMBER++)
                else
                    mainActivityPresenter.loadPropertiesWithFilters(PAGE_NUMBER++,
                            ap_filter, building_filter, furnishing_filter)
            } else {
                showNetworkDialog()
            }
        } else {
            Toast.makeText(this, "No more properties found", Toast.LENGTH_SHORT).show();
        }
    }

    private fun showNetworkDialog() {
        var alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setMessage("Seems like you don't have an internet connection")
        alertDialogBuilder.setPositiveButton("Retry",
                { _, _ ->
                    loadData()
                })
        alertDialogBuilder.setNegativeButton("Cancel",
                { _, _ ->
                    finish()
                })

        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.create().show()
    }

    companion object {
        var PAGE_NUMBER: Int = 0
    }

    override fun onDataFetched(properties: Properties) {
        loadMoreContainer.visibility = View.GONE
        if (properties.data.size == 0)
            dataLeft = false
        propertiesArrayList.addAll(properties.data)
        propertiesAdapter.setPropertiesArrayList(propertiesArrayList)
        propertiesAdapter.notifyDataSetChanged()
    }

    override fun onError(errorMessage: String) {
        Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 101) {
            propertiesArrayList.clear()
            propertiesAdapter.setPropertiesArrayList(propertiesArrayList)
            propertiesAdapter.notifyDataSetChanged()
            PAGE_NUMBER = 0
            isFilterApplied = true
            dataLeft = true

            ap_filter = data!!.getStringExtra(AppConstants.AP_FILTER)
            building_filter = data!!.getStringExtra(AppConstants.BUILDING_FILTER)
            furnishing_filter = data!!.getStringExtra(AppConstants.FURNISHING_FILTER)

            if (CommonUtil.isNetworkConnected(this)) {
                mainActivityPresenter.loadPropertiesWithFilters(PAGE_NUMBER++,
                        ap_filter,
                        building_filter,
                        furnishing_filter)
            } else {
                showNetworkDialog()
            }
        }
    }
}
