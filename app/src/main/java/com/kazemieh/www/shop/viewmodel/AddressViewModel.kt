package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.address.UserAddress
import com.kazemieh.www.shop.data.model.category.SubCategory
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.AddressRepository
import com.kazemieh.www.shop.repository.CategoryRepository
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val repository: AddressRepository) :
    ViewModel() {


    val userAddressList =
        MutableStateFlow<NetworkResult<List<UserAddress>>>(NetworkResult.Loading())

    init {
        getUserAddressList(USER_TOKEN)
    }

    private fun getUserAddressList(token: String) {
        viewModelScope.launch {
            userAddressList.emit(repository.getUserAddressList(token))
        }
    }

}