package com.topuz.kotlinbonappetit._api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DaoInterface {
    @GET("list.php?a=list")
    fun allCountries(): Call<countryResponse>
    @GET ("categories.php")
    fun allCategories():Call<CategoryResponse>
//filter.php?c=Canadian
    @GET("filter.php")
    fun getCategoryFoods(@Query("c") c:String):Call<foodListResponse>
    // ya da ?a=
    @GET("filter.php")
    fun getCountryFood(@Query("a") a:String):Call<foodListResponse>
//lookup.php?i=52767
    @GET("lookup.php")
    fun getDetail(@Query("i") i:String):Call<detailResponse>
}