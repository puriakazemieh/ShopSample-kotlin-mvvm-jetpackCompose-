package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.model.home.MainCategory
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val amazingSuperMarketItems =
        MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val proposalBanners = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val categories = MutableStateFlow<NetworkResult<List<MainCategory>>>(NetworkResult.Loading())
    val centerBannerItems = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch {
            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                amazingItems.emit(repository.getAmazingItem())
            }
            launch {
                amazingSuperMarketItems.emit(repository.getAmazingSuperMarketItems())
            }
            launch {
                proposalBanners.emit(repository.getProposalBanners())
            }
            launch {
                categories.emit(repository.getCategories())
            }
            launch {
                centerBannerItems.emit(repository.getCenterBanners())
            }
        }
    }


    suspend fun getSlider() {
        viewModelScope.launch {
            slider.emit(repository.getSlider())
        }
    }

    suspend fun getAmazingItem() {
        viewModelScope.launch {
            amazingItems.emit(repository.getAmazingItem())
        }
    }


}