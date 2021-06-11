package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class countryResponse(
    @SerializedName("meals")
    @Expose
    var countries:List<countryClass>
                           ) {
}