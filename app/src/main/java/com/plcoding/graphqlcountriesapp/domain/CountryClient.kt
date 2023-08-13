package com.plcoding.graphqlcountriesapp.domain

interface CountryClient {
    suspend fun getCountryList(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}