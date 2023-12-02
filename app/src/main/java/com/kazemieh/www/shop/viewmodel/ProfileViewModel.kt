package com.kazemieh.www.shop.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazemieh.www.shop.data.model.category.SubCategory
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.repository.CategoryRepository
import com.kazemieh.www.shop.repository.ProfileRepository
import com.kazemieh.www.shop.ui.screens.profile.ProfileScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: ProfileRepository) :
    ViewModel() {

        //sharedViewModel
        var screenState by mutableStateOf(ProfileScreenState.LOGIN_STATE)
        var inputPhoneState by mutableStateOf("")
        var inputPasswordState by mutableStateOf("")





}