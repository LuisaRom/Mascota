package com.example.carnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
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
                val datos = remember { mutableStateOf(RegistroDatos()) }

                NavHost(navController, startDestination = "screenA") {
                    composable("screenA") { ScreenA(navController, datos) }
                    composable("screenB") { ScreenB(datos.value) }
                }
            }
        }
    }
}

data class RegistroDatos(
    var nombre: String = "",
    var raza: String = "",
    var tamaño: String = "",
    var edad: String = "",
    var urlImagen: String = ""
)