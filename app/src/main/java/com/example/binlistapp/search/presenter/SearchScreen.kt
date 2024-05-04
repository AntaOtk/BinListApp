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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.search.domain.model.CardInfo
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
            is SearchState.Content -> InfoPresenter((currentData as SearchState.Content).cardInfo, viewModel, modifier)
            is SearchState.Error -> Text(text = (currentData as SearchState.Error).errorMessage)
            SearchState.Default -> Unit
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
fun InfoPresenter(currentData: CardInfo, viewmodel: SearchViewModel, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(HellGrey)
            .padding(16.dp)
    ) {
        Text(
            color = Color.Gray,
            text = "BANK:"
        )
        Text(
            text = currentData.bank?.name ?: "-"
        )
        Spacer(modifier = modifier.padding(vertical = 8.dp))
        Text(
            color = Color.Gray,
            text = "Brand:"
        )
        Text(
            modifier = modifier.clickable { println("Clicked") },
            text = currentData.brand
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            color = Color.Gray,
            text = "Url:"
        )
        Text(
            modifier = modifier.clickable { currentData.bank?.url?.let { viewmodel.moveToUrl(it) } },
            text = currentData.bank?.url ?: "-"
        )
        Spacer(modifier = modifier.padding(vertical = 8.dp))
        Text(
            color = Color.Gray,
            text = "Мобильный телефон:"
        )
        Text(
            modifier = modifier.clickable { currentData.bank?.phone?.let { viewmodel.moveToCall(it) } },
            text = currentData.bank?.phone ?: "-"
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            color = Color.Gray,
            text = "country"
        )
        Text(
            modifier = modifier.clickable { currentData.country?.name?.let { viewmodel.moveToMap(it) } },
            text = currentData.country?.name ?: "-",
        )
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
