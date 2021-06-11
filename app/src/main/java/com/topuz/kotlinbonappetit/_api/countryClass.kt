package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class countryClass (
    @SerializedName("strArea")
    @Expose
    var cntry:String){

}