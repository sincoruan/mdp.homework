package com.example.tablelayouttest

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var maplist:HashMap<String,String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        maplist.put("android 9.0","pre")
        maplist.put("android 10.0","pro")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for((key,value) in maplist){
            addrow(key,value)
        }
    }

    fun click_add(view: View) {
        var col1 = android_version.text.toString();
        var col2 = android_code.text.toString();
        if(col1.isBlank()||col1.isEmpty()||col2.isBlank()||col2.isEmpty()||col1.equals("")||col2.equals("")){

            var toast = Toast.makeText(this,"the input can not be null",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,100,200)
            toast.show()
        }
        else
            addrow(android_version.text.toString(),android_code.text.toString())
    }
    fun addrow(col1:String,col2:String){

        // Create a new table row.
        val tableRow = TableRow(getApplicationContext())
        // Set new table row layout parameters.
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        //tableRow.setLayoutParams(layoutParams)

        layoutParams.height=45
        layoutParams.setMargins(3,3,4,3)
        tableRow.setBackgroundColor(Color.WHITE)

        // add values into row by calling addView()
        var textviewtmp = TextView(this)
        textviewtmp.text=col1
        textviewtmp.setBackgroundColor(Color.WHITE)
        textviewtmp.layoutParams = layoutParams
        textviewtmp.setBackgroundColor(resources.getColor(R.color.colorAccent))

        tableRow.addView(textviewtmp,0)

        textviewtmp = TextView(this)
        textviewtmp.layoutParams = layoutParams
        textviewtmp.text=col2
        textviewtmp.setBackgroundColor(resources.getColor(R.color.colorAccent))

        tableRow.addView(textviewtmp,1)

        // Finally add the created row row into layout
        tableLayout.addView(tableRow) // id from Layout_file

    }
}
