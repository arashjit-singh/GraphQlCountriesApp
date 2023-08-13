package com.plcoding.graphqlcountriesapp.domain

data class DetailedCountry(
    val code: String,
    val capital: String,
    val emoji: String,
    val name: String,
    val currency: String,
    val languages: List<String>,
    val continent: String,
)
