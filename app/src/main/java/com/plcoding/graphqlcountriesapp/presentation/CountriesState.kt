package com.plcoding.graphqlcountriesapp.presentation

import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry

data class CountriesState(
    val isLoading: Boolean = false,
    val countryList: List<SimpleCountry> = emptyList(),
    val selectedCountry: DetailedCountry? = null,
)
