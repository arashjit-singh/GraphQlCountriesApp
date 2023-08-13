package com.plcoding.graphqlcountriesapp.data

import com.plcoding.CountriesQuery
import com.plcoding.CountryQuery
import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        capital = capital ?: "No Capital",
        currency = currency ?: "No Currency",
        emoji = emoji,
        continent = continent.name,
        languages = languages.map {
            it.name
        }
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        emoji = emoji,
        capital = capital ?: "No capital",
        name = name,
        code = code
    )
}