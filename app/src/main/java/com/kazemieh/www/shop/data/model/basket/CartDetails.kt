package com.kazemieh.www.shop.data.model.basket

data class CartDetails(
    val totalCount: Int,
    val totalPrice: Long,
    val totalDiscount: Long,
    val payablePrice: Long
)