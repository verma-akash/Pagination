package com.gravity.nobroker

import android.content.Context
import android.net.ConnectivityManager
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

/**
 * Created by Akash Verma on 24/07/18.
 */
class CommonUtil {

    companion object {

        fun isNetworkConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }

        fun convertToAmount(amount: String): String {

            if (amount != null && !amount.isEmpty()) {

                val locale = Locale("en", "IN")
                val decimalFormat = DecimalFormat.getCurrencyInstance(locale) as DecimalFormat
                val dfs = DecimalFormatSymbols.getInstance(locale)
                dfs.currencySymbol = "\u20B9"
                decimalFormat.decimalFormatSymbols = dfs

                val bigDecimal = BigDecimal(amount).toLong()
                val count = Math.floor(Math.log10(Math.abs(bigDecimal).toDouble()) + 1).toInt()
                var value: Double
                return when {
                    count in 6..7 -> {
                        value = bigDecimal.toDouble() / 100000
                        decimalFormat.format(getFormatDoubleValue(value, 2)) + " Lacs"
                    }
                    count >= 8 -> {
                        value = bigDecimal.toDouble() / 10000000
                        decimalFormat.format(getFormatDoubleValue(value, 2)) + " Cr"
                    }
                    count in 4..5 -> decimalFormat.format(java.lang.Double.parseDouble(amount))
                    else -> "₹ " + getFormatDoubleValue(java.lang.Double.parseDouble(amount), 2)!!
                }

            } else {
                return ""
            }
        }

        private fun getFormatDoubleValue(value: Double?, k: Int): Double? {
            return Math.round(value!! * Math.pow(10.0, k.toDouble())) / Math.pow(10.0, k.toDouble())
        }

        fun formatFurnishingText(furnishing: String): String {
            var result: String = furnishing[0] + furnishing.replace("_", " ").substring(1, furnishing.length)
            return result
        }

        fun getImageUrl(imageUrl: String): String {
            return imageUrl.split("_")[0] + "/" + imageUrl
        }

        fun getApartmentMapping(apartmentType: String): String {
            return when {
                apartmentType.equals(AppConstants.BHK1, true) -> AppConstants.BHK1_MAPPING
                apartmentType.equals(AppConstants.BHK2, true) -> AppConstants.BHK2_MAPPING
                apartmentType.equals(AppConstants.BHK3, true) -> AppConstants.BHK3_MAPPING
                else -> {
                    ""
                }
            }
        }

        fun getBuildingMapping(filterString: String): String {
            return when {
                filterString.equals(AppConstants.APARTMENT, true) -> AppConstants.APARTMENT_MAPPING
                filterString.equals(AppConstants.INDEPENDENT_HOUSE, true) -> AppConstants.INDEPENDENT_HOUSE_MAPPING
                filterString.equals(AppConstants.INDEPENDENT_FLOOR, true) -> AppConstants.INDEPENDENT_FLOOR_MAPPING
                else -> {
                    ""
                }
            }
        }

        fun getFurnishingMapping(filterString: String): String {
            return when {
                filterString.equals(AppConstants.FULLY_FURNISH, true) -> AppConstants.FULLY_FURNISH_MAPPING
                filterString.equals(AppConstants.SEMI_FURNISH, true) -> AppConstants.SEMI_FURNISH_MAPPING
                else -> {
                    ""
                }
            }
        }

        fun isApartmentFilterSelected(apartmentType: String, filter: String): Boolean {
            return filter.contains(getApartmentMapping(apartmentType))
        }

        fun isBuildingFilterSelected(buildingType: String, filter: String): Boolean {
            return filter.contains(getBuildingMapping(buildingType))
        }

        fun isFurnishingFilterSelected(furnishingType: String, filter: String): Boolean {
            return filter.contains(getFurnishingMapping(furnishingType))
        }
    }
}