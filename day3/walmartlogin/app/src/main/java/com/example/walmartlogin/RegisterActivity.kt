package com.example.walmartlogin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import com.example.walmartlogin.domain.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onClickRegister(view: View) {
        if(firstname.text.toString()=="")   {
            Toast.makeText(this,"first name can not be null",Toast.LENGTH_LONG).show()
        }
        if(lastname.text.toString()=="")    {
            Toast.makeText(this,"lastname can not be null",Toast.LENGTH_LONG).show()
        }
        if(emailaddress.text.toString()==""){
            Toast.makeText(this,"email address can not be null",Toast.LENGTH_LONG).show()
        }
        if(password.text.toString()=="")    {
            Toast.makeText(this,"password can not be null",Toast.LENGTH_LONG).show()
        }

        val firstname = firstname.text.toString()
        val lastname = lastname.text.toString()
        val emailaddress = emailaddress.text.toString()
        val password = password.text.toString()

        if(firstname.isNotEmpty()&&lastname.isNotEmpty()&&emailaddress.isNotEmpty()&&password.isNotEmpty())
        {
            val data = Intent()
            data.putExtra("user",User(firstname,lastname,emailaddress,password))
            setResult(Activity.RESULT_OK,data)
            finish()
        }
    }
}
