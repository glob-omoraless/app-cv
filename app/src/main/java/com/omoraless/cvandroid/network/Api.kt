package com.omoraless.cvandroid.network

import com.omoraless.cvandroid.model.CV
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("/glob-omoraless/40b11327700a6b95dfe964bd7801d276/raw/5dbfd252e8991fa49035aae0dddfe34bbe37ac50/cvinfo.json")
   fun getCVData(): Observable<CV>
}