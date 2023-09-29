package com.vgrigorchik.bilet_6razryad.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vgrigorchik.bilet_6razryad.navigation.NavRoute
import com.vgrigorchik.bilet_6razryad.ui.theme.Bilet_6razryadTheme


@Composable
fun StartScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Выберите раздел")
            Button(
                onClick = {
                          navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Room database")
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Firebase database")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevStartScreen () {
    Bilet_6razryadTheme {
        StartScreen(navController = rememberNavController())
    }
}