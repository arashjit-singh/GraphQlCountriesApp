package com.plcoding.graphqlcountriesapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CountriesScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        if (state.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        LazyColumn {
            items(state.value.countryList) {
                CountryItem(model = it) {
                    viewModel.selectCountry(it)
                }
            }
        }

        state.value.selectedCountry?.let {
            CountryDialog(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color.White)
                    .padding(16.dp),
                country = it,
                onDismiss = {
                    viewModel.dismissDialog()
                })
        }
    }
}