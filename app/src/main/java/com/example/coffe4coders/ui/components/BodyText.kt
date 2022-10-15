package com.example.coffe4coders.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun BodyText(body: String) {
    Text(body,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Preview(
    showBackground = true
)
@Composable
fun BodyTextPreview() {
    Coffe4CodersTheme {
        BodyText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris et porttitor purus. Ut tempor, urna ut vehicula varius, tellus neque finibus libero, ut tempor risus dolor eu ante. Aenean posuere, lacus eu aliquam volutpat, est erat facilisis lacus, quis faucibus dui ipsum eget ante.")
    }
}