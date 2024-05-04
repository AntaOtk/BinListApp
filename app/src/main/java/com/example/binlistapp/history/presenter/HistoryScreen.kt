package com.example.binlistapp.history.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.search.domain.model.CardInfo
import com.example.binlistapp.ui.theme.HellGrey
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: HistoryViewModel = koinViewModel()
) {
    Column {
        TopBar(modifier, navController)
        Button(onClick = { viewModel.cleanHistory() },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            content = { Text("Очистить историю поиска") })
        viewModel.listInfo.forEach { HistoryInfoCard(modifier, viewModel, it) }
    }
}

@Composable
fun TopBar(modifier: Modifier, navController: NavHostController) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }
        Text(
            modifier = modifier.align(Alignment.CenterVertically),
            text = "History"
        )
    }
}

@Composable
fun HistoryInfoCard(modifier: Modifier, viewmodel: HistoryViewModel, currentData: CardInfo) {
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
            text = "BANK: ${currentData.bank?.name ?: "-"}"
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
                    modifier = modifier.clickable {
                        currentData.country?.name?.let {
                            viewmodel.goToMap(
                                it
                            )
                        }
                    },
                    text = currentData.country?.name ?: "",
                )
            }
            Column {
                Text(
                    color = Color.Gray,
                    text = "Url:"
                )
                Text(
                    modifier = modifier.clickable {
                        currentData.bank?.url?.let {
                            viewmodel.goToUrl(
                                it
                            )
                        }
                    },
                    text = currentData.bank?.url ?: ""
                )
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
                    text = currentData.bank?.phone ?: ""
                )
            }
        }
    }
}