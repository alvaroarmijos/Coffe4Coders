package com.example.coffe4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utilities.MockDataProvider

@Composable
fun FeedScreen(navController: NavController) {
    var list = MockDataProvider.listOfProducts()
    Scaffold(
        topBar = {
            CustomAppBar("Coffee4Coders")
        },
        content = {
            Coffe4CodersTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        item {
                            Column(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                TitleText("Bienvenido")
                                BodyText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris et porttitor purus. Ut tempor, urna ut vehicula varius, tellus neque finibus libero, ut tempor risus dolor eu ante.")
                            }
                        }
                        items(list){product ->
                            ProductCard(product
                            ) {
                                navController.navigate("detail/${product.id}"){
                                    launchSingleTop = true
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    Coffe4CodersTheme {
        FeedScreen(navController)
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun FeedScreenPreviewDark() {
    val navController = rememberNavController()
    Coffe4CodersTheme {
        FeedScreen(navController)
    }
}
