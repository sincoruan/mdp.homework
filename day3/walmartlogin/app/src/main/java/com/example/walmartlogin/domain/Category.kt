package com.example.walmartlogin.domain

import java.io.Serializable

class Category :Serializable{
    lateinit var name:String
    var imageuri:Int = 0
    var productList:Array<Product> = emptyArray()

    constructor(name:String,imageuri:Int){
        this.name=name
        this.imageuri=imageuri
    }
}