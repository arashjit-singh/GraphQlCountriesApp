package com.plcoding.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.GetCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase,
) : ViewModel() {

    private var _uiState = MutableStateFlow(CountriesState())
    val uiState = _uiState.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            _uiState.update {
                it.copy(
                    isLoading = false,
                    countryList = getCountriesUseCase.execute()
                )
            }
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }
            _uiState.update {
                it.copy(
                    isLoading = false,
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dismissDialog() {
        _uiState.update {
            it.copy(
                isLoading = false,
                selectedCountry = null
            )
        }
    }
}