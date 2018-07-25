package com.gravity.nobroker.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.RequestManager
import com.gravity.nobroker.AppConstants
import com.gravity.nobroker.CommonUtil
import com.gravity.nobroker.R
import com.gravity.nobroker.base.BaseActivity
import com.gravity.nobroker.injection.qualifiers.ActivityContextQualifier
import com.gravity.nobroker.models.Datum
import kotlinx.android.synthetic.main.single_property_holder.view.*
import java.util.*
import javax.inject.Inject

/**
 * Created by Akash Verma on 24/07/18.
 */

class PropertiesAdapter : RecyclerView.Adapter<PropertiesAdapter.PropertyHolder> {

    private val context: Context
    private var propertiesArrayList: ArrayList<Datum>? = null
    private val glide: RequestManager

    @Inject
    constructor(@ActivityContextQualifier context: BaseActivity, glide: RequestManager) {
        this.context = context
        this.glide = glide
    }

    fun setPropertiesArrayList(propertiesArrayList: ArrayList<Datum>) {
        this.propertiesArrayList = propertiesArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_property_holder, parent, false)
        return PropertyHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyHolder, position: Int) {

        if (!propertiesArrayList!![position].photos.isEmpty()
                && propertiesArrayList!![position].photos[0] != null
                && propertiesArrayList!![position].photos[0].imagesMap.medium != null) {

            holder.propertyImage!!.scaleType = ImageView.ScaleType.FIT_XY

            glide.load(AppConstants.IMAGE_BASE_URL
                    + CommonUtil.getImageUrl(propertiesArrayList!![position].photos[0].imagesMap.medium))
                    .placeholder(R.drawable.ic_home_24dp)
                    .error(R.drawable.ic_home_24dp)
                    .into(holder.propertyImage)

        } else {
            holder.propertyImage!!.scaleType = ImageView.ScaleType.FIT_CENTER
            holder.propertyImage!!.setImageDrawable(context.getDrawable(R.drawable.ic_home_24dp))
        }

        holder.propertyTitle!!.text = propertiesArrayList!![position].title
        if (!propertiesArrayList!![position].secondaryTitle.isEmpty())
            holder.secondaryTitle!!.text = "at " + propertiesArrayList!![position].secondaryTitle
        else
            holder.secondaryTitle!!.text = " "

        holder.rent!!.text = CommonUtil.convertToAmount(propertiesArrayList!![position].rent)
        holder.furnishing!!.text = CommonUtil.formatFurnishingText(propertiesArrayList!![position].furnishing)

        if (propertiesArrayList!![position].bathroom == 0)
            holder.bathrooms!!.text = "-"
        if (propertiesArrayList!![position].bathroom == 1)
            holder.bathrooms!!.text = propertiesArrayList!![position].bathroom.toString() + " Bathroom"
        else
            holder.bathrooms!!.text = propertiesArrayList!![position].bathroom.toString() + " Bathrooms"

        holder.propertySize!!.text = propertiesArrayList!![position].propertySize.toString() + " Sq. ft."

        if (position == propertiesArrayList!!.size - 2)
            (context as MainActivity).loadData()


        if (!propertiesArrayList!![position].isFavourite) {
            holder.favourite!!.setImageResource(R.drawable.ic_favorite_border_24dp)
        } else {
            holder.favourite!!.setImageResource(R.drawable.ic_favorite_24dp)
        }

        holder.favourite!!.setOnClickListener {
            if (propertiesArrayList!![position].isFavourite) {
                propertiesArrayList!![position].isFavourite = false
                holder.favourite!!.setImageResource(R.drawable.ic_favorite_border_24dp)
                Toast.makeText(context, "Property Un-Shortlisted", Toast.LENGTH_SHORT).show()
            } else {
                propertiesArrayList!![position].isFavourite = true
                holder.favourite!!.setImageResource(R.drawable.ic_favorite_24dp)
                Toast.makeText(context, "Property Shortlisted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return propertiesArrayList!!.size
    }

    inner class PropertyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var propertyImage: ImageView? = null
        var propertyTitle: TextView? = null
        var secondaryTitle: TextView? = null
        var rent: TextView? = null
        var furnishing: TextView? = null
        var bathrooms: TextView? = null
        var propertySize: TextView? = null
        var favourite: ImageView? = null

        init {
            this.propertyImage = itemView.propertyImage
            this.propertyTitle = itemView.propertyTitle
            this.secondaryTitle = itemView.secondaryTitle
            this.rent = itemView.rent
            this.furnishing = itemView.furnishing
            this.bathrooms = itemView.bathrooms
            this.propertySize = itemView.propertySize
            this.favourite = itemView.favourite
        }
    }

    interface AdapterListener {
        fun loadData()
    }
}