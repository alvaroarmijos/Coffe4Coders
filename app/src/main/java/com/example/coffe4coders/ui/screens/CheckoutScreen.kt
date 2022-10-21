package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.models.Product
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utilities.MockDataProvider

@Composable
fun CheckoutScreen(
    navController: NavController,
    product: Product,
) {
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
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            CustomAppBar(navigationIcon = Icons.Filled.ArrowBack){
                navController.navigate("detail/${product.id}")
            }

        },
        content = {
            Alert(title = "Felicidades", message = message) {
                navController.navigate("feed"){
                    launchSingleTop = true
                    popUpTo("feed")
                }
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ProductCard(
                    product
                ) {}

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    CustomTextField(value = name, placeholder = "Nombre completo"){
                        name = it
                    }
                    CustomTextField(value = email, placeholder = "Correo electrónico"){
                        email = it
                    }
                    CustomTextField(value = phone, placeholder = "Número telefónico"){
                        phone = it
                    }
                    CustomTextField(value = address, placeholder = "Dirección de residencia"){
                        phone = it
                    }
                    DropdownTextField(suggestions = cities, value = city, placeholder = "Ciudad"){
                        city = it
                    }
                    Column {
                        Row {
                           Text(text = "Subtotal", style = MaterialTheme.typography.caption)
                           Text(text = "$ 35.00 USD", style = MaterialTheme.typography.body2,
                               textAlign = TextAlign.End,
                           modifier = Modifier.fillMaxWidth())
                        }
                        Row {
                            Text(text = "Envio", style = MaterialTheme.typography.caption)
                            Text(text = "$ 10.00 USD", style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth())
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "$ 45.00 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start)
                        CustomButton(label = "Finalizar Pedido") {
                            //Validate all fields
                            message = "Tu pedido ha sido creado :)"
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
fun CheckoutScreenPreview() {
    val product = MockDataProvider.getProductBy(0)
    if (product!=null){
        val navController = rememberNavController()
        Coffe4CodersTheme {
            CheckoutScreen(navController, product)
        }
    } else {
        Text(text = "Error en preview")
    }
}