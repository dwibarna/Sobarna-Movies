package com.sobarna.sobarnamovies.model

data class TvShow(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)