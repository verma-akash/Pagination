package com.gravity.nobroker.ui

import android.content.Intent
import android.os.Bundle
import com.gravity.nobroker.AppConstants
import com.gravity.nobroker.CommonUtil
import com.gravity.nobroker.R
import com.gravity.nobroker.base.BaseActivity
import com.gravity.nobroker.custom.FilterObject
import kotlinx.android.synthetic.main.activity_filter.*
import javax.inject.Inject

/**
 * Created by Akash Verma on 25/07/18.
 */
class FilterActivity : BaseActivity(), FilterMvpView {

    @Inject
    lateinit var filterPresenter: FilterPresenter

    private var apartmentSelectedFilter = ""
    private var buildingSelectedFilter = ""
    private var furnishingSelectedFilter = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        getActivityComponent().inject(this)
        filterPresenter.onAttach(this)

        if(intent.hasExtra(AppConstants.AP_FILTER))
            apartmentSelectedFilter = intent.getStringExtra(AppConstants.AP_FILTER)

        if(intent.hasExtra(AppConstants.BUILDING_FILTER))
            buildingSelectedFilter = intent.getStringExtra(AppConstants.BUILDING_FILTER)

        if(intent.hasExtra(AppConstants.FURNISHING_FILTER))
            furnishingSelectedFilter = intent.getStringExtra(AppConstants.FURNISHING_FILTER)

        var apartmentFilterList = ArrayList<FilterObject>()
        apartmentFilterList.add(FilterObject("AT", AppConstants.BHK1, CommonUtil.isApartmentFilterSelected(AppConstants.BHK1, apartmentSelectedFilter)))
        apartmentFilterList.add(FilterObject("AT", AppConstants.BHK2, CommonUtil.isApartmentFilterSelected(AppConstants.BHK2, apartmentSelectedFilter)))
        apartmentFilterList.add(FilterObject("AT", AppConstants.BHK3, CommonUtil.isApartmentFilterSelected(AppConstants.BHK3, apartmentSelectedFilter)))
        apartmentFilter.setFilterList(apartmentFilterList)

        var buildingFilterList = ArrayList<FilterObject>()
        buildingFilterList.add(FilterObject("BT", AppConstants.APARTMENT, CommonUtil.isBuildingFilterSelected(AppConstants.APARTMENT, buildingSelectedFilter)))
        buildingFilterList.add(FilterObject("BT", AppConstants.INDEPENDENT_HOUSE, CommonUtil.isBuildingFilterSelected(AppConstants.INDEPENDENT_HOUSE, buildingSelectedFilter)))
        buildingFilterList.add(FilterObject("BT", AppConstants.INDEPENDENT_FLOOR, CommonUtil.isBuildingFilterSelected(AppConstants.INDEPENDENT_FLOOR, buildingSelectedFilter)))

        buildingFilter.setFilterList(buildingFilterList)

        var furnishingFilterList = ArrayList<FilterObject>()
        furnishingFilterList.add(FilterObject("FT", AppConstants.FULLY_FURNISH, CommonUtil.isFurnishingFilterSelected(AppConstants.FULLY_FURNISH, furnishingSelectedFilter)))
        furnishingFilterList.add(FilterObject("FT", AppConstants.SEMI_FURNISH, CommonUtil.isFurnishingFilterSelected(AppConstants.SEMI_FURNISH, furnishingSelectedFilter)))
        furnishingFilter.setFilterList(furnishingFilterList)

        applyButton.setOnClickListener {
            apartmentSelectedFilter = ""
            buildingSelectedFilter = ""
            furnishingSelectedFilter = ""

            for (filerObject in apartmentFilter.selectedFilterList) {
                if (filerObject.isSelected) {
                    if (!apartmentSelectedFilter.isEmpty())
                        apartmentSelectedFilter += "/"

                    apartmentSelectedFilter += CommonUtil.getApartmentMapping(filerObject.filterString)
                }
            }

            for (filerObject in buildingFilter.selectedFilterList) {
                if (filerObject.isSelected) {
                    if (!buildingSelectedFilter.isEmpty())
                        buildingSelectedFilter += "/"

                    buildingSelectedFilter += CommonUtil.getBuildingMapping(filerObject.filterString)
                }
            }

            for (filerObject in furnishingFilter.selectedFilterList) {
                if (filerObject.isSelected) {
                    if (!furnishingSelectedFilter.isEmpty())
                        furnishingSelectedFilter += "/"

                    furnishingSelectedFilter += CommonUtil.getFurnishingMapping(filerObject.filterString)
                }
            }

            val intent = Intent()
            intent.putExtra(AppConstants.AP_FILTER, apartmentSelectedFilter)
            intent.putExtra(AppConstants.BUILDING_FILTER, buildingSelectedFilter)
            intent.putExtra(AppConstants.FURNISHING_FILTER, furnishingSelectedFilter)
            setResult(101, intent)
            finish()
        }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        filterPresenter.onDetach()
        super.onDestroy()
    }
}