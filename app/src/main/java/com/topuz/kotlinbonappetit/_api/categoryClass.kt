package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class categoryClass (
    @SerializedName("strCategory")
    @Expose
    var catName:String,
    @SerializedName("strCategoryThumb")
    @Expose
    var catUrl:String,
    @SerializedName("strCategoryDescription")
    @Expose
    var catDescription:String
        ){
}