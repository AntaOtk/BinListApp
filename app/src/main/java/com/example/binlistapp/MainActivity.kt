package com.example.binlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.binlistapp.ui.SearchViewModel
import com.example.binlistapp.ui.theme.BinListAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<SearchViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinListAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        SimpleTextField()
                        Column {
                            Text(text = "@")
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun SimpleTextField() {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = text,
            label = { Text(text = "Enter BIN code") },
            onValueChange = {
                text = it
            }
        )
    }
}