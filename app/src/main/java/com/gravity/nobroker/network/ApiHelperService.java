package com.gravity.nobroker.network;

import com.gravity.nobroker.models.Properties;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Akash Verma on 24/07/18.
 */

public interface ApiHelperService {

    @GET("property/filter/region/ChIJLfyY2E4UrjsRVq4AjI7zgRY/?lat_lng=12.9279232,77.6271078&rent=0,500000&travelTime=30")
    Observable<Properties> getProperties(@Query("pageNo") String pageNo);

    @GET("property/filter/region/ChIJLfyY2E4UrjsRVq4AjI7zgRY/?lat_lng=12.9279232,77.6271078&rent=0,500000&travelTime=30")
    Observable<Properties> getPropertiesWithFilter(@Query("pageNo") String pageNo,
                                         @Query("type") String type,
                                         @Query("buildingType") String buildingType,
                                         @Query("furnishing") String furnishing);

}
