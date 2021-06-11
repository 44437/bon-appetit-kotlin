package com.topuz.kotlinbonappetit.Adapters
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.topuz.kotlinbonappetit.R
import com.topuz.kotlinbonappetit._api.categoryClass
import com.topuz.kotlinbonappetit.pagetwo
import kotlinx.android.synthetic.main.categories_layout.view.*

class categoryAdapter(private  val context: Context,private val ctgories:ArrayList<categoryClass>,
                ):
RecyclerView.Adapter<categoryAdapter.ViewHolder>(){


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imageViewCategory:ImageView=view.categoryImageView
        val textViewCategory:TextView=view.categoryTextView
        val cardViewCategory:CardView=view.categoryCardView
        val textViewCategory2:TextView=view.categoryTextView2

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_layout,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(ctgories[position].catUrl).into(holder.imageViewCategory)
        val title:String=ctgories[position].catName
        holder.textViewCategory.text=title
        holder.textViewCategory2.text=ctgories[position].catDescription
        holder.cardViewCategory.setOnClickListener {
            val intent= Intent(context,pagetwo::class.java)
            intent.putExtra("data","c$title")
            context.startActivity(intent)
        }
    }

    override fun getItemCount() =ctgories.size

}

