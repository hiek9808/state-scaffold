package com.sumaqada.statescaffold

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumaqada.state_scaffold.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)
    val uiState: StateFlow<UiState<String>> = _uiState

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            delay(2_000)

            _uiState.value = UiState.Success("Data loaded successfully")

        }
    }
}