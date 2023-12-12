package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.model.productdetail.NewComment
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.ProductDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) :
    ViewModel() {

    val productDetail = MutableStateFlow<NetworkResult<ProductDetail>>(NetworkResult.Loading())
    fun getProductById(productId: String) {
        viewModelScope.launch {
            productDetail.emit(repository.getProductById(productId))
        }
    }




    val similarProducts =
        MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())
    fun getSimilarProducts(categoryId: String) {
        viewModelScope.launch {
            similarProducts.emit(repository.getSimilarProducts(categoryId))
        }
    }


    val newCommentResult =
        MutableStateFlow<NetworkResult<String>>(NetworkResult.Loading())
    fun setNewComment(newComment: NewComment) {
        viewModelScope.launch {
            newCommentResult.emit(repository.setNewComment(newComment))
        }
    }


}