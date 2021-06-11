package com.topuz.kotlinbonappetit._api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("categories")
    @Expose
    var categories:List<categoryClass>
        ){
}