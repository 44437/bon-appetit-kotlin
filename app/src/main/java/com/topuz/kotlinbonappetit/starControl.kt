package com.topuz.kotlinbonappetit

import android.content.Context
import android.content.SharedPreferences


class starControl  {
    fun control(context: Context,id:String):Boolean{
        val sp: SharedPreferences = context.getSharedPreferences("star",Context.MODE_PRIVATE)
        return sp.getBoolean(id,false)
    }
    fun addOrRemove(context: Context,id:String){
        val sp: SharedPreferences = context.getSharedPreferences("star",Context.MODE_PRIVATE)
        val editor=sp.edit()
        val isYellow:Boolean=sp.getBoolean(id,false)
        if(isYellow){
            editor.putBoolean(id,false)
            editor.apply()
        }
        else{
            editor.putBoolean(id,true)
            editor.apply()
        }

    }
}