package com.topuz.kotlinbonappetit.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.topuz.kotlinbonappetit.R
import com.topuz.kotlinbonappetit.pagetwo
import kotlinx.android.synthetic.main.country_layout.view.*
class countryAdapter(private val context:Context,private val data: ArrayList<String>):
RecyclerView.Adapter<countryAdapter.ViewHolder>(){
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textView: TextView=view.countryTextView
        val cardViewCountry: CardView=view.countryCard
    }
    override fun onCreateViewHolder(viewGroup:  ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.country_layout,viewGroup,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val title:String=data[position]
        viewHolder.textView.text=title
        viewHolder.cardViewCountry.setOnClickListener {
            val intent= Intent(context, pagetwo::class.java)
            intent.putExtra("data","a$title")
            context.startActivity(intent)
        }
    }
    override fun getItemCount()=data.size
}