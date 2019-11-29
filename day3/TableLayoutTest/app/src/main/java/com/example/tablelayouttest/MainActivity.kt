package com.example.tablelayouttest

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.TableRow
import android.widget.TextView
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
        tableRow.setBackgroundColor(Color.GREEN)

        // add values into row by calling addView()
        var textviewtmp = TextView(this)
        textviewtmp.text=col1
        textviewtmp.setBackgroundColor(Color.WHITE)
        textviewtmp.layoutParams = layoutParams
        tableRow.addView(textviewtmp,0)

        textviewtmp = TextView(this)
        textviewtmp.layoutParams = layoutParams
        textviewtmp.text=col2
        textviewtmp.setBackgroundColor(Color.WHITE)

        tableRow.addView(textviewtmp,1)

        // Finally add the created row row into layout
        tableLayout.addView(tableRow) // id from Layout_file

    }
}
