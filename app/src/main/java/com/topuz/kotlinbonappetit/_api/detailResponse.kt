package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class detailResponse(
    @SerializedName("meals")
    @Expose
    var detailData:List<detailClass>
) {
}