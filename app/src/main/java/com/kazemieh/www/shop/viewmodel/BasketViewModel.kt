package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {


    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    val currentCartItems : Flow<List<CartItem>> = repository.currentCartItems
    val nextCartItems : Flow<List<CartItem>> = repository.nextCartItems

    fun getSuggestedItems() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

    fun insertCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(item)
        }
    }

    fun removeFromCart(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromCart(item)
        }
    }

    fun changeCountCartItem(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCountCartItem(id, newCount)
        }
    }

    fun changeStatusCartItem(id: String, newCartStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeStatusCartItem(id, newCartStatus)
        }
    }


}