package com.topuz.kotlinbonappetit._api

class ApiUtils {
    companion object{
        val BASE_URL="YOUR_API"
        fun getDaoInterface():DaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(DaoInterface::class.java)
        }
    }
}