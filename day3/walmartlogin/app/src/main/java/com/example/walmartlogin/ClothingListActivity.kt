package com.example.walmartlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.walmartlogin.domain.Category
import kotlinx.android.synthetic.main.activity_clothing_list.*
import kotlinx.android.synthetic.main.activity_main.*
class ClothingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothing_list)

        var intent = intent
        var category: Category =intent.getSerializableExtra("category") as Category

        val adapter = ArrayAdapter<Any>(this, android.R.layout.simple_spinner_dropdown_item, category.productList)
        lview.adapter = adapter

        lview.onItemClickListener =
            AdapterView.OnItemClickListener {
                    parent, view, position, id ->
                var product = category.productList[position]
                Toast.makeText(this,"you have click the $product",Toast.LENGTH_LONG).show()
            }
    }
}
