package com.example.walmartlogin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlogin.ProductListActivity
import com.example.walmartlogin.R
import com.example.walmartlogin.domain.Category

class MyAdapter(var context: Context, private val myDataset: Array<Category>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.category_image)
        val name = itemView.findViewById<TextView>(R.id.category_name)
        //var parentLayout = itemView.findViewById<LinearLayout>(R.id.category_image)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_view, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(productView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.image.setImageResource(myDataset[position].imageuri)
        holder.name.text = myDataset[position].name

        holder.image.setOnClickListener{
            //Toast.makeText(context,"clicked!",Toast.LENGTH_LONG).show()

            var intent = Intent(context,ProductListActivity::class.java)
            intent.putExtra("category",myDataset[position])
            context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}