package com.example.coffe4coders.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen() {
    Text(text = "Hola soy un detalle")
}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenView() {
    DetailScreen()
}