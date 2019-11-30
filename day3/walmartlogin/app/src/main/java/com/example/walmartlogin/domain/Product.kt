package com.example.walmartlogin.domain

import java.io.Serializable

class Product :Serializable{
    var title: String? = null
    var price:Double = 0.toDouble()
    var color:String? = null
    var image:Int = 0 // name of the image
    var itemid:String? =null
    var desc:String?= null  // Description of the product

    constructor(
        title: String?,
        price: Double,
        color: String?,
        image: Int,
        itemid: String?,
        desc: String?
    ) {
        this.title = title
        this.price = price
        this.color = color
        this.image = image
        this.itemid = itemid
        this.desc = desc
    }
}