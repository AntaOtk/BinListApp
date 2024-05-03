package com.example.binlistapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.binlistapp.damain.model.InfoData


@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel(),
    modifier: Modifier
) {
    val currentData: InfoData? by viewModel.infoData.observeAsState(null)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        BINTextField(viewModel, modifier)
        currentData?.let { InfoPresenter(it, modifier) }
    }
}

@Composable
fun InfoPresenter(currentData: InfoData, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Text(
            color = Color.Gray,
            text = "BANK:"
        )
        Text(
            modifier = modifier.clickable { println("Clicked") },
            text = currentData.bank.name
        )
        Text(
            color = Color.Gray,
            text = "Url:"
        )
        Text(
            modifier = modifier.clickable { println("Clicked") },
            text = currentData.bank.url
        )
        Text(
            color = Color.Gray,
            text = "Мобильный телефон:"
        )
        Text(
            modifier = modifier.clickable { println("Clicked") },
            text = currentData.bank.phone
        )
        Text(
            color = Color.Gray,
            text = "City"
        )
        Text(
            modifier = modifier.clickable { println("Clicked") },
            text = currentData.bank.city,
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
        Button(
            modifier = modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            onClick = { viewModel.searchInfo(text.toString()) }, content = { Text("Начать поиск") })
    }

}
