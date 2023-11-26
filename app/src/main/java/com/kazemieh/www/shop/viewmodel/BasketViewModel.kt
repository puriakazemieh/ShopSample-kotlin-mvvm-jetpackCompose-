package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {


    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    fun getSuggestedItems(){
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }
}