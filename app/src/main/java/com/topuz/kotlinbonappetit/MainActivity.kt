package com.topuz.kotlinbonappetit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.topuz.kotlinbonappetit.Adapters.categoryAdapter
import com.topuz.kotlinbonappetit.Adapters.countryAdapter
import com.topuz.kotlinbonappetit._api.ApiUtils
import com.topuz.kotlinbonappetit._api.CategoryResponse
import com.topuz.kotlinbonappetit._api.categoryClass
import com.topuz.kotlinbonappetit._api.countryResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pagethree.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var  _countryAdapter:countryAdapter
    private  lateinit var _categoryAdapter:categoryAdapter
    var categoryLoadControl:Boolean=false
    var countryLoadControl:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hide()
        getCountry()
        getCategory()
    }
    private  fun getCategory(){
        var arr = arrayListOf<categoryClass>()
        //foodCategories.layoutManager=  GridLayoutManager(this, 2)
        foodCategories.layoutManager=LinearLayoutManager(this)
        val client=ApiUtils.getDaoInterface()
        client.allCategories().enqueue(object :
        Callback<CategoryResponse>{
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                val dataArr=response.body()!!.categories
                for(i in dataArr){
                    arr.add(i)
                }
                foodCategories.apply {
                    _categoryAdapter= categoryAdapter(context,arr)
                    adapter=_categoryAdapter
                }
                categoryLoadControl=true
                if (countryLoadControl)
                    show()
            }
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
            }
        })
    }
    private  fun getCountry(){
        var arr= arrayListOf<String>()
        val client=ApiUtils.getDaoInterface()
        countrys.layoutManager=LinearLayoutManager(this)
        client.allCountries().enqueue(object :
        Callback<countryResponse> {
        override fun onResponse(
            call: Call<countryResponse>,
            response: Response<countryResponse>
        ) {
            val dataArr= response.body()!!.countries
            for(i in dataArr){
                arr.add(i.cntry)
            }
            countrys.apply {
                _countryAdapter= countryAdapter(context,arr)
                adapter=_countryAdapter
            }
            countryLoadControl=true
            if(categoryLoadControl)
                show()
        }
        override fun onFailure(call: Call<countryResponse>, t: Throwable) {
        }
    })
    }
    fun show() { mainLinear.visibility=View.VISIBLE
        homePageLoadingBar.hide()
    }
    fun hide(){ mainLinear.visibility=View.INVISIBLE
    }
}