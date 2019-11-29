package com.example.walmartlogin.domain

import java.io.Serializable

class User:Serializable{
    lateinit var username:String
    lateinit var password:String
    lateinit var firstname:String
    lateinit var lastname:String

    constructor(username:String,password:String){
        this.username=username
        this.password=password
    }
    constructor(firstname:String,lastname:String,username:String,password:String):this(username,password){
        this.firstname=firstname
        this.lastname=lastname
    }
}