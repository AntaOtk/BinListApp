package com.example.binlistapp.search.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.R
import com.example.binlistapp.contact.ToConnectProvider
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.search.domain.model.Country
import com.example.binlistapp.ui.theme.HellGrey
import org.koin.androidx.compose.koinViewModel


@Composable
fun SearchScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: SearchViewModel = koinViewModel()
) {
    val currentData: SearchState by viewModel.cardState.observeAsState(SearchState.Default)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        BINTextField(viewModel, modifier)
        when (currentData) {
            is SearchState.Content -> InfoPresenter(
                (currentData as SearchState.Content).cardInfo,
                viewModel,
                modifier
            )

            is SearchState.Error -> ErrorText(
                (currentData as SearchState.Error).errorMessage,
                modifier
            )

            SearchState.Default -> Spacer(modifier = modifier.padding(4.dp))
        }

        Button(onClick = { navController.navigate(route = "Second") },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            content = { Text("Посмотрть историю поиска") })
    }
}

@Composable
fun ErrorText(message: String, modifier: Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        textAlign = TextAlign.Center,
        text = message
    )
}

@Composable
fun InfoPresenter(currentData: CardInfo, viewmodel: ToConnectProvider, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(HellGrey)
            .padding(8.dp)
    ) {
        NonClickableInfo(R.string.scheme, currentData.scheme, modifier)
        NonClickableInfo(R.string.type, currentData.type, modifier)
        NonClickableInfo(R.string.brand, currentData.brand, modifier)
        CountryColumn(currentData.country, modifier, viewmodel)
        NonClickableInfo(R.string.bank_name, currentData.bank?.name ?: "-", modifier)
        if (!currentData.bank?.url.isNullOrEmpty()) {
            Text(
                color = Color.Gray,
                text = "Url:"
            )
            Text(
                modifier = modifier.clickable { currentData.bank?.url?.let { viewmodel.goToUrl(it) } },
                text = currentData.bank?.url ?: "-"
            )
        }
        if (!currentData.bank?.url.isNullOrEmpty()) {
            Text(
                color = Color.Gray,
                text = "Мобильный телефон:"
            )
            Text(
                modifier = modifier.clickable {
                    currentData.bank?.phone?.let {
                        viewmodel.goToCall(
                            it
                        )
                    }
                },
                text = currentData.bank?.phone ?: "-"
            )
        }
        NonClickableInfo(R.string.bank_city, currentData.bank?.city, modifier)
    }
}

@Composable
fun CountryColumn(country: Country?, modifier: Modifier, viewmodel: ToConnectProvider) {
    Column {
        Text(
            color = Color.Gray,
            text = stringResource(id = R.string.country)
        )
        Text(
            modifier = modifier.clickable {
                country?.let {
                    viewmodel.goToMap(
                        it.latitude,
                        it.longitude
                    )
                }
            },
            text = country?.name ?: "-",
        )
    }
}

@Composable
fun NonClickableInfo(text: Int, text1: String?, modifier: Modifier) {
    if (!text1.isNullOrEmpty()) {
        Column {
            Text(
                color = Color.Gray,
                text = stringResource(id = text)
            )
            Text(
                modifier = modifier.clickable { println("Clicked") },
                text = text1
            )
        }
    }
}

@Composable
fun BINTextField(
    viewModel: SearchViewModel,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = text,
            label = { Text(text = "Enter BIN code") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                text = it
            },
            maxLines = 1,
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Button(
            modifier = modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = { viewModel.searchInfo(text.text) }, content = { Text("Начать поиск") })
    }

}
