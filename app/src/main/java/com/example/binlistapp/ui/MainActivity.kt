package com.example.binlistapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.binlistapp.history.presentation.HistoryScreen
import com.example.binlistapp.search.presentation.SearchScreen
import com.example.binlistapp.ui.theme.BinListAppTheme

class MainActivity : ComponentActivity() {

    private val modifier = Modifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinListAppTheme {
                Surface(
                    modifier = modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    CustomNavHost(navController = navController,)
                }
            }
        }
    }

    @Composable
    private fun CustomNavHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = FIRST_SCREEN) {
            composable(FIRST_SCREEN) {
                SearchScreen(navController, modifier)
            }
            composable(SECOND_SCREEN) {
                HistoryScreen(navController, modifier)
            }
        }
    }

    companion object {
        const val FIRST_SCREEN = "First"
        const val SECOND_SCREEN = "Second"
    }
}