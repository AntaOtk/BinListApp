package com.example.binlistapp.search.presentation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.binlistapp.R
import com.example.binlistapp.ui.MainActivity.Companion.SECOND_SCREEN
import com.example.binlistapp.ui.theme.blueColor
import com.example.binlistapp.ui.theme.white
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
            is SearchState.Content -> InfoCard(
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
        Button(onClick = { navController.navigate(route = SECOND_SCREEN) },
            colors = ButtonDefaults.buttonColors(
                containerColor = blueColor,
                contentColor = white
            ),
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            contentPadding = ButtonDefaults.ContentPadding,
            content = { Text(text = stringResource(id = R.string.to_history_button)) })
    }
}

@Composable
fun ErrorText(message: String, modifier: Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(8.dp),
        textAlign = TextAlign.Center,
        color = Color.Black,
        text = message
    )
}

@Preview(
    showSystemUi = false, showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun ErrorTextPreview() {
    ErrorText(message = "dsfsdffsdf", modifier = Modifier)
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
            label = { Text(text = stringResource(id = R.string.search_hint)) },
            colors = TextFieldDefaults.colors(
                focusedLabelColor = blueColor,
                focusedIndicatorColor = blueColor,
                focusedTrailingIconColor = blueColor,
                cursorColor = blueColor,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions { },
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
            onClick = { viewModel.searchInfo(text.text) },
            colors = ButtonDefaults.buttonColors(
                containerColor = blueColor,
                contentColor = white
            ),
            content = { Text(text = stringResource(id = R.string.start_search)) })
    }

}
