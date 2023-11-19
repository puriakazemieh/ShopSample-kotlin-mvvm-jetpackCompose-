package com.kazemieh.www.shop.viewmodel

import androidx.lifecycle.ViewModel
import com.kazemieh.www.shop.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
}