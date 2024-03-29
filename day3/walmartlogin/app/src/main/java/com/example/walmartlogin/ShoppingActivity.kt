package com.example.walmartlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.walmartlogin.domain.Category
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_shopping.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.SimpleAdapter
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlogin.adapter.MyAdapter
import com.example.walmartlogin.domain.Product


class ShoppingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var myDataset: Array<Category>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        initData()

        //get username from the main activity
        var intent = intent
        var textView = findViewById<TextView>(R.id.sayhello)
        textView.text = "welcome!!" + intent.getStringExtra("username")

        //list the product category
        viewManager = GridLayoutManager(this, 2)
        viewAdapter = MyAdapter(this,myDataset)

        shoopingcategory.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            //setHasFixedSize(true)

            // use a grid layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    fun initData() {
        var cate1 = Category("electronic", R.drawable.product1)
        cate1.productList = arrayOf(
            Product("mac",15.0,"red",R.drawable.ep1,"1","this is a very good mac"),
            Product("pro",18.0,"red",R.drawable.ep2,"2","this is a very good mac"),
            Product("del",25.0,"red",R.drawable.ep3,"3","this is a very good mac"),
            Product("hp",35.0,"red",R.drawable.ep4,"4","this is a very good mac"),
            Product("acer",45.0,"red",R.drawable.ep5,"5","this is a very good mac")
        )
        var cate2 = Category("cloth", R.drawable.product2)
        cate2.productList = arrayOf(
            Product("cloth1",25.0,"red",R.drawable.product1,"1","this is a very good cloth"),
            Product("cloth2",35.0,"red",R.drawable.product2,"1","this is a very good cloth"),
            Product("cloth3",55.0,"red",R.drawable.product3,"1","this is a very good cloth"),
            Product("cloth4",65.0,"red",R.drawable.product1,"1","this is a very good cloth"),
            Product("cloth5",85.0,"red",R.drawable.product1,"1","this is a very good cloth")
        )
        var cate3 = Category("cosmetics", R.drawable.product3)
        cate3.productList = arrayOf(
            Product("lip",15.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("facer",15.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("mac",15.0,"red",R.drawable.product2,"1","this is a very good mac"),
            Product("mac",15.0,"red",R.drawable.product3,"1","this is a very good mac"),
            Product("mac",15.0,"red",R.drawable.product4,"1","this is a very good mac")
        )
        var cate4 = Category("food", R.drawable.product4)
        cate4.productList = arrayOf(
            Product("apple",15.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("pear",35.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("other",45.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("mac1",75.0,"red",R.drawable.product1,"1","this is a very good mac"),
            Product("mac2",15.0,"red",R.drawable.product1,"1","this is a very good mac")
        )
        myDataset = arrayOf(cate1,cate2,cate3,cate4)
    }
}