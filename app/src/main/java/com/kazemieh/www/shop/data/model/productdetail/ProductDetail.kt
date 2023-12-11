package com.kazemieh.www.shop.data.model.productdetail


data class ProductDetail(
    val _id: String? = null,
    val name: String? = null,
    val seller: String? = null,
    val category: String? = null,
    val categoryId: String? = null,
    val price: Long? = null,
    val description: String? = null,
    val discountPercent: Int? = null,
    val star: Double? = null,
    val starCount: Int? = null,
    val viewCount: Int? = null,
    val commentCount: Int? = null,
    val questionCount: Int? = null,
    val agreeCount: Int? = null,
    val agreePercent: Int? = null,
    val imageSlider: List<SliderImage>? = null,
    val colors: List<ProductColor>? = null,
    val comments: List<Comment>? = null
)

data class SliderImage(
    val _id: String,
    val image: String,
    val productId: String
)

data class ProductColor(
    val _id: String,
    val color: String,
    val code: String
)

data class Comment(
    val _id: String,
    val title: String,
    val description: String,
    val productId: String,
    val userId: String,
    val userName: String,
    val updatedAt: String,
    val createdAt: String,
    val __v: Int
)

