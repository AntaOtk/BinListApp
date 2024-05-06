package com.example.binlistapp.history.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: HistoryViewModel = koinViewModel()
) {
    viewModel.getHistory()
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        TopBar(modifier, navController)
        Button(onClick = { viewModel.cleanHistory() },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            content = { Text(text = stringResource(id = R.string.clear_history_button)) })
        Spacer(modifier = modifier.padding(vertical = 8.dp))
        viewModel.listInfo.forEach { ExpandableCard(modifier, viewModel, it) }
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
            text = stringResource(id = R.string.second_screen_title)
        )
    }
}
