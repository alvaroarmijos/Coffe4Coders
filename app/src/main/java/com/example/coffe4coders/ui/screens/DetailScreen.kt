package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

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
            Column(
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ){
                    Image(
                        painter = painterResource(id = countryISO.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TitleText(title = "Café de Colombia")
                    Text(text = "Lorem ipsum dolor sit amet",
                        style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vel ligula bibendum, euismod dolor sed, consequat ex. Ut ullamcorper, orci quis dictum cursus, neque leo lobortis est, a feugiat sem nisi et mauris. Nunc convallis eu tellus sit amet cursus.")
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "$ 35 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        CustomButton(label = "Continuar") {
                            navController.navigate("checkout/${countryISO.iso}"){
                                launchSingleTop = true
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
fun DetailScreenView() {
    val navController = rememberNavController()

    Coffe4CodersTheme {
        DetailScreen(navController, CountryISO.COL)
    }
}