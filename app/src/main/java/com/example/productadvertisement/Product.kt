package com.example.productadvertisement

import android.graphics.drawable.Drawable

data class Product(

    //var imageidprod : Int,
    var imageidprod:Drawable?,
    var srno : String,
    var name : String,
    var price:String
)

