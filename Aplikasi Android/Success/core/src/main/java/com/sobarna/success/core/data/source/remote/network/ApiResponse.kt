package com.sobarna.success.core.data.source.remote.network

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : com.sobarna.success.core.data.source.remote.network.ApiResponse<T>()
    data class Error(val errorMessage: String) : com.sobarna.success.core.data.source.remote.network.ApiResponse<Nothing>()
    object Empty : com.sobarna.success.core.data.source.remote.network.ApiResponse<Nothing>()
}