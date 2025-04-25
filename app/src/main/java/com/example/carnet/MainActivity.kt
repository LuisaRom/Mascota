package com.example.carnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.*
import com.example.carnet.ui.theme.CarnetTheme
import com.example.carnet.ui.theme.ScreenA
import com.example.carnet.ui.theme.ScreenB

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarnetTheme {
                val navController = rememberNavController()
                val nombre = rememberSaveable { mutableStateOf("") }
                val raza = rememberSaveable { mutableStateOf("") }
                val tamanio = rememberSaveable { mutableStateOf("") }
                val edad = rememberSaveable { mutableStateOf("") }
                val fotoUrl = rememberSaveable { mutableStateOf("") }

                NavHost(navController = navController, startDestination = "screen_a") {
                    composable("screen_a") {
                        ScreenA(
                            nombre = nombre,
                            raza = raza,
                            tamanio = tamanio,
                            edad = edad,
                            fotoUrl = fotoUrl,
                            navController = navController
                        )
                    }
                    composable("screen_b") {
                        ScreenB(
                            nombre = nombre.value,
                            raza = raza.value,
                            tamanio = tamanio.value,
                            edad = edad.value,
                            fotoUrl = fotoUrl.value,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
