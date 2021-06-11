package com.topuz.kotlinbonappetit

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import com.topuz.kotlinbonappetit.Adapters.categoryAdapter
import com.topuz.kotlinbonappetit._api.ApiUtils
import com.topuz.kotlinbonappetit._api.CategoryResponse
import com.topuz.kotlinbonappetit._api.detailResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pagethree.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class pagethree : AppCompatActivity() {
    private var strcntrl=starControl()
    lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagethree)

        val text:String=intent.getStringExtra("id").toString()

        sp=getSharedPreferences("star", Context.MODE_PRIVATE)

        yellowControl(text)
        getDetails(text)
        hide()
        detailBackButton.setOnClickListener {
            finish()
        }
        detailFoodStar.setOnClickListener {
            strcntrl.addOrRemove(this ,text)
            yellowControl(text)

        }
    }
    fun getDetails(text:String){
        val client= ApiUtils.getDaoInterface()
        client.getDetail(text).enqueue(object :Callback<detailResponse>{
            override fun onResponse(
                call: Call<detailResponse>,
                response: Response<detailResponse>
            ) {
                val data=response.body()!!.detailData
                Picasso.get().load(data[0].url).into(detailImageView)
                productName.text=data[0].name
                productCategory.text=data[0].category
                productDescription.text=data[0].content
                show()
            }

            override fun onFailure(call: Call<detailResponse>, t: Throwable) {
                finish()
            }
        })
}
    fun show(){ nestedScrollView2.visibility=View.VISIBLE
        foodDetailLoading.hide()
    }
    fun hide(){ nestedScrollView2.visibility=View.INVISIBLE
    }
    fun yellowControl(controlId:String){
        val isYellow:Boolean=sp.getBoolean(controlId,false)
        if (isYellow)
            detailFoodStar.setImageResource(R.drawable.ic_baseline_star_24)
        else
            detailFoodStar.setImageResource(R.drawable.ic_baseline_star_border_24)
    }
}
