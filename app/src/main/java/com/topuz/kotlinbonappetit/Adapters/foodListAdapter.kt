package com.topuz.kotlinbonappetit.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.topuz.kotlinbonappetit.R
import com.topuz.kotlinbonappetit._api.page2foodListClass
import kotlinx.android.synthetic.main.foodlistcard.view.*
import com.squareup.picasso.Picasso
import com.topuz.kotlinbonappetit.pagethree
import com.topuz.kotlinbonappetit.starControl

class foodListAdapter (private val context: Context, private val data:ArrayList<page2foodListClass>):
RecyclerView.Adapter<foodListAdapter.ViewHolder>(){
    val starcntrl=starControl()
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageView:ImageView=view.foodListImageView
        val cardView: CardView=view.foodListCardView
        val textView:TextView=view.foodListTextView
        val star:ImageView=view.foodStar

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.foodlistcard,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(data[position].foodUrl).into(holder.imageView)
        val id:String=data[position].foodId
        holder.textView.text=data[position].foodName

        var isYellow=starcntrl.control(context,id)
        if (isYellow) {
            holder.star.setImageResource(R.drawable.ic_baseline_star_24)
        }
        holder.star.setOnClickListener {
            //Toast.makeText(context,id.toString(),Toast.LENGTH_LONG).show()
            starcntrl.addOrRemove(context,id)
            val temp:Boolean =starcntrl.control(context,id)
            if(temp){
                holder.star.setImageResource(R.drawable.ic_baseline_star_24)
            }
            else{
                holder.star.setImageResource(R.drawable.ic_baseline_star_border_24)
            }
        }
        holder.cardView.setOnClickListener{
            val intent= Intent(context,pagethree::class.java)
            intent.putExtra("id",id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount()=data.size
}

