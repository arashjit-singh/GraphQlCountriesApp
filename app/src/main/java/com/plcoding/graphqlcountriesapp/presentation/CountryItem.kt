package com.plcoding.graphqlcountriesapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry

@Composable
fun CountryItem(
    modifier: Modifier = Modifier,
    model: SimpleCountry,
    onCountrySelected: (String) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onCountrySelected(model.code)
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = model.emoji,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1.0f)) {
            Text(text = model.name, style = TextStyle(fontSize = 24.sp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = model.capital, style = TextStyle(fontSize = 18.sp))
        }
    }
}