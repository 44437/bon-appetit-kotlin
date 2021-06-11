package com.topuz.kotlinbonappetit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.topuz.kotlinbonappetit.Adapters.categoryAdapter
import com.topuz.kotlinbonappetit.Adapters.foodListAdapter
import com.topuz.kotlinbonappetit._api.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pagetwo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class pagetwo : AppCompatActivity() {
    private lateinit var _foodListAdapter:foodListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagetwo)
        var text:String=intent.getStringExtra("data").toString()
        getList(text)
        backButton.setOnClickListener {
            finish()
        }
    }
    private fun getList(text:String){
        foodListRecyclerView.layoutManager=GridLayoutManager(this,2)

        var arr= arrayListOf<page2foodListClass>()

        val client= ApiUtils.getDaoInterface()
        var requestCall:Call<foodListResponse>

        var s=text.first()
        val Text=text.drop(1)
        foodListTitle.text=Text
        if (s=='c'){
            requestCall=client.getCategoryFoods(Text)
        }
        else{
            requestCall=client.getCountryFood(Text)
        }
        requestCall.enqueue(object :
            Callback<foodListResponse> {
            override fun onResponse(
                call: Call<foodListResponse>,
                response: Response<foodListResponse>
            ) {
                val dataArr=response.body()!!.foods
               // Log.e("asdasdd",dataArr.toString())

                for (i in dataArr){
                    arr.add(i)
                }
                foodListRecyclerView.apply {
                    _foodListAdapter=foodListAdapter(context ,arr)
                    adapter=_foodListAdapter
                }
                foodListLoading.visibility=View.GONE
            }
            override fun onFailure(call: Call<foodListResponse>, t: Throwable) {
                finish()
            }

        })
    }
}