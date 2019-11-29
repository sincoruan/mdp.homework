package com.example.walmartlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.walmartlogin.dao.*
import com.example.walmartlogin.domain.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var userList:UserList = UserList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickLogin(view: View) {
        println(userList.userList.size)
        var userview = findViewById<EditText>(R.id.username)
        var passview = findViewById<EditText>(R.id.password)
        var username:String = userview.text.toString()
        var password:String = passview.text.toString()

        var user:User?=userList.getUserByname(username)

        if(user==null)
            Toast.makeText(getApplicationContext(),"invalid username!",Toast.LENGTH_LONG).show()
        else if(!user.password.equals(password)){
            Toast.makeText(this,"invalid password!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"login success!",Toast.LENGTH_LONG).show()
            var intent = Intent(this,ShoppingActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
        }
    }

    fun onClickRegister(view: View) {
        var intent=Intent(this,RegisterActivity::class.java)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode==Activity.RESULT_OK){
                val user:User = data!!.getSerializableExtra("user") as User
                userList.addUser(user)
                username.text = Editable.Factory.getInstance().newEditable(user.username)
            }
        }
    }

    fun onClickForgetPass(view: View) {
        val user:User? = userList.getUserByname(username.text.toString())
        if(user!=null){
            var input = user.password
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, input)
            startActivity(intent)

        }
    }
}
