package com.example.walmartlogin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlogin.DetailActivity
import com.example.walmartlogin.ProductListActivity
import com.example.walmartlogin.R
import com.example.walmartlogin.domain.Category
import com.example.walmartlogin.domain.Product

class ProductListAdapter(var context: Context, private val productList: Array<Product>) :
    RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.product_title)
        val color = itemView.findViewById<TextView>(R.id.product_color)
        val image = itemView.findViewById<ImageView>(R.id.product_image)
        val desc = itemView.findViewById<TextView>(R.id.product_desc)
        val price = itemView.findViewById<TextView>(R.id.product_price)

        var parentLayout = itemView
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.color.text = productList[position].color
        holder.desc.text = productList[position].desc
        holder.title.text = productList[position].title
        holder.price.text = productList[position].price.toString()
        holder.image.setImageResource( productList[position].image)

        holder.itemView.setOnClickListener{
            var intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("product",productList[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListAdapter.MyViewHolder {
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_view, parent, false)
        return ProductListAdapter.MyViewHolder(productView)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = productList.size
}