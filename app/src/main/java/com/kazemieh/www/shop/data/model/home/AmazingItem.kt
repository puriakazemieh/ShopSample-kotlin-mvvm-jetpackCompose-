package com.kazemieh.www.shop.data.model.home

data class AmazingItem(
    val _id: String,
    val discountPercent: Int,
    val image: String,
    val name: String,
    val price: Long,
    val seller: String
)