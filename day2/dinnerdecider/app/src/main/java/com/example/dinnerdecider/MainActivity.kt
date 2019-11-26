package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foodList:List<String> = mutableListOf( "Hamburger", "Pizza", "Mexican", "American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addfood_click(view: View) {
        foodList+=foodtext.text.toString()
    }
    fun decide_click(view: View) {
        var i:Int = Random.nextInt(0, foodList.size)
        foodview.text = foodList.get(i)
    }

}
