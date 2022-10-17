package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CountryISO
import com.example.coffe4coders.ui.components.CustomAppBar

@Composable
fun DetailScreen(
    navController: NavController,
    countryISO: CountryISO
) {
    Scaffold(
        topBar = {
            CustomAppBar(
                navigationIcon = Icons.Filled.ArrowBack
            ){
                navController.navigate("feed"){
                    popUpTo("feed")
                }
            }
        },
        content = {

        }
    )

}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenView() {
    val navController = rememberNavController()

    DetailScreen(navController, CountryISO.COL)
}