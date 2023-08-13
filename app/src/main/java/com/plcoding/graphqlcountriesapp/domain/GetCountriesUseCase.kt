package com.plcoding.graphqlcountriesapp.domain

class GetCountriesUseCase(private val countryClient: CountryClient) {

    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountryList().sortedBy {
            it.name
        }
    }
}