package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import com.kazemieh.www.shop.repository.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {


}