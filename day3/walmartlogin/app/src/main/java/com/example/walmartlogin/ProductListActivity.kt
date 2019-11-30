package com.example.walmartlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlogin.adapter.MyAdapter
import com.example.walmartlogin.adapter.ProductListAdapter
import com.example.walmartlogin.domain.Category
import kotlinx.android.synthetic.main.activity_product_list.*
import kotlinx.android.synthetic.main.activity_shopping.*
import kotlinx.android.synthetic.main.product_item_view.*

class ProductListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        var intent = intent
        var category:Category =intent.getSerializableExtra("category") as Category

        viewManager = LinearLayoutManager(this)
        category.productList
        viewAdapter = ProductListAdapter(this,category.productList)

        productlist.apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            //setHasFixedSize(true)

            // use a grid layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

    }
}
