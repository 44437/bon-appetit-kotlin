package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class foodListResponse (
    @SerializedName("meals")
    @Expose
    var foods:List<page2foodListClass>
){
}