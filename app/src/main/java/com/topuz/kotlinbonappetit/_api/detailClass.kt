package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class detailClass (
    @SerializedName("strMeal")
    @Expose
    var name:String,
    @SerializedName("strCategory")
    @Expose
    var category:String,
    @SerializedName("strMealThumb")
    @Expose
    var url:String,
    @SerializedName("strInstructions")
    @Expose
    var content:String,
){
}