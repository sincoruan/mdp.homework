package com.example.walmartlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        var intent = intent
        var textView = findViewById<TextView>(R.id.sayhello)
        textView.text = "welcome!!"+intent.getStringExtra("username")
    }
}
