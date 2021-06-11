package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class page2foodListClass  (
    @SerializedName("strMeal")
    @Expose
    var foodName:String
    ,
    @SerializedName("strMealThumb")
    @Expose
    var foodUrl:String,
    @SerializedName("idMeal")
    @Expose
    var foodId:String
        ){
}