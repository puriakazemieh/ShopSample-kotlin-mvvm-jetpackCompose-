package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.chekcout.ConfirmPurchase
import com.kazemieh.www.shop.data.model.chekcout.OrderDetail
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.CheckoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CheckoutViewModel @Inject constructor(private val repository: CheckoutRepository) :
    ViewModel() {


    val shippingCost = MutableStateFlow<NetworkResult<Int>>(NetworkResult.Loading())
    fun getShippingCost(address : String){
        viewModelScope.launch {
            shippingCost.emit(repository.getShippingCost(address))
        }
    }

    val orderResponse = MutableStateFlow<NetworkResult<String>>(NetworkResult.Loading())
    fun addNewOrder(cartOrderDetail: OrderDetail) {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                orderResponse.emit(repository.setNewOrder(cartOrderDetail))
            }
        }
    }


    val purchaseResponse = MutableStateFlow<NetworkResult<String>>(NetworkResult.Loading())
    fun confirmPurchase(confirmPurchase: ConfirmPurchase) {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                purchaseResponse.emit(repository.confirmPurchase(confirmPurchase))
            }
        }
    }

}