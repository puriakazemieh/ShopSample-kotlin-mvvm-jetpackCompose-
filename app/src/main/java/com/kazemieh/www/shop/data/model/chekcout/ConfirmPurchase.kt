package com.kazemieh.www.shop.data.model.chekcout


data class ConfirmPurchase(
    val orderId: String,
    val token: String,
    val transactionId: String
)
