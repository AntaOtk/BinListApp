package com.example.binlistapp.history.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.search.domain.model.InfoData
import com.example.binlistapp.search.presenter.SearchViewModel
import com.example.binlistapp.ui.theme.HellGrey
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: HistoryViewModel = koinViewModel()
) {
    ListOfInfo(viewModel.listInfo, modifier)
}

@Composable
fun ListOfInfo(items: List<InfoData>, modifier: Modifier) {
    Column { items.forEach { /*InfoPresenter(it, modifier) */ } }
}

@Composable
fun HistoryInfoCard(currentData: InfoData, viewmodel: SearchViewModel, modifier: Modifier) {
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
            text = "BANK: ${currentData.bank.name}"
        )
        Row {
            Column {
                Text(
                    color = Color.Gray,
                    text = "Brand: ${currentData.brand}"
                )
                Spacer(modifier = modifier.padding(vertical = 8.dp))
                Text(
                    color = Color.Gray,
                    text = "country"
                )
                Text(
                    modifier = modifier.clickable { viewmodel.moveToMap(currentData.countryName) },
                    text = currentData.countryName,
                )
            }
            Column {
                Text(
                    color = Color.Gray,
                    text = "Url:"
                )
                Text(
                    modifier = modifier.clickable { viewmodel.moveToUrl(currentData.bank.url) },
                    text = currentData.bank.url
                )
                Text(
                    color = Color.Gray,
                    text = "Мобильный телефон:"
                )
                Text(
                    modifier = modifier.clickable { viewmodel.moveToCall(currentData.bank.phone) },
                    text = currentData.bank.phone
                )
            }
        }
    }
}