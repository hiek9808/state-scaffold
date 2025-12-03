package com.sumaqada.state_scaffold

sealed interface UiState<out T> {

    data object Loading : UiState<Nothing>
    data object Empty : UiState<Nothing>
    data class Error(
        val message: String,
        val exception: Throwable? = null
    ) : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>

}