package com.plcoding.graphqlcountriesapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlprep.R

@Composable
fun CountryDialog(modifier: Modifier = Modifier, country: DetailedCountry, onDismiss: () -> Unit) {

    val languages = remember {
        country.languages.joinToString()
    }

    Dialog(onDismissRequest = { onDismiss() }) {
        Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                Text(
                    text = country.emoji, fontSize = 30.sp
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1.0f)) {
                    Text(text = country.name, style = TextStyle(fontSize = 24.sp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            LabelItem(label = stringResource(R.string.continent), value = country.continent)
            Spacer(modifier = Modifier.height(8.dp))
            LabelItem(label = stringResource(R.string.capital), value = country.capital)
            Spacer(modifier = Modifier.height(8.dp))
            LabelItem(label = stringResource(R.string.currency), value = country.currency)
            Spacer(modifier = Modifier.height(8.dp))
            LabelItem(label = stringResource(R.string.language_s), value = languages)

        }

    }
}

@Composable
fun LabelItem(label: String, value: String) {
    Text(text = "$label $value")
}
