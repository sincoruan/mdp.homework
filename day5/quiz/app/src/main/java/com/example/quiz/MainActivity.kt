package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TableLayout
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var  tablelayout = findViewById<TableLayout>(R.id.quiz_table)

    }

    fun onClickSubmit(view: View) {
        var score = calculateScore()
        var builder = AlertDialog.Builder(this)
        builder.setTitle("score")
        builder.setIconAttribute(AlertDialog.BUTTON_NEUTRAL)
        val ctime=getTime()
        val message = """
            your score is ${score}
            test date:$ctime
        """.trimIndent()
        builder.setMessage(message)

        val dialog: AlertDialog = builder.create()
        dialog.show()
        //reset()
    }
    fun onClickReset(view: View) {
        reset()
    }

    //calculate the score
    fun calculateScore():Int{
        var total = 0
        if(findViewById<RadioGroup>(R.id.quiz_radiogroup).checkedRadioButtonId==R.id.rd_yes) total+=50
        if(findViewById<CheckBox>(R.id.quiz_check1).isChecked==true
            &&findViewById<CheckBox>(R.id.quiz_check2).isChecked==true
            &&findViewById<CheckBox>(R.id.quiz_check3).isChecked==true)
            total+=50
        return total
    }
    //reset the checked box and radio button
    fun reset(){
        findViewById<RadioGroup>(R.id.quiz_radiogroup).clearCheck()
        findViewById<CheckBox>(R.id.quiz_check1).isChecked=false
        findViewById<CheckBox>(R.id.quiz_check2).isChecked=false
        findViewById<CheckBox>(R.id.quiz_check3).isChecked=false
    }
    //get the date time
    fun getTime():String{
        val c = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val  mMonth = c.get(Calendar.MONTH)
        val  mDay = c.get(Calendar.DAY_OF_MONTH)
        val time = SimpleDateFormat("HH:mm").format(c.time)
        return "$mMonth/$mDay/$mYear $time"
    }
}
