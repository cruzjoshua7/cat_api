package com.verycool.catapicall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verycool.catapicall.data.model.CatsDetailsItemModel
import com.verycool.catapicall.domain.GetCatsUseCase
import com.verycool.catapicall.domain.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val getCats : GetCatsUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel(){

    private val _catsState  = MutableStateFlow<UiState<List<CatsDetailsItemModel>>>(UiState.LOADING)
    val catsState = _catsState.asStateFlow()

    init {
        retrieveCats()
    }

    fun retrieveCats(
        limit: Int = 10,
        hasBreed : Int = 1
    ){
        viewModelScope.launch(dispatcher) {
            getCats(limit,hasBreed).collect{
                _catsState.value = it
            }
        }
    }
}