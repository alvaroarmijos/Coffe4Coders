package com.example.coffe4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.components.CustomTextField
import com.example.coffe4coders.ui.components.DropdownTextField

@Composable
fun CheckoutScreen() {
    val cities = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )
    var city by remember { mutableStateOf("") }

    DropdownTextField(suggestions = cities, value = city, placeholder = "Ciudad"){
        city = it
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreen()
}