package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>
}