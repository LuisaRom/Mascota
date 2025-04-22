package com.example.carnet.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.carnet.RegistroDatos

@Composable
fun ScreenA(navController: NavController, datos: MutableState<RegistroDatos>) {
    var nombre by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var tamaño by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }

    Surface(color = AzulOscuro, modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                "Registro del Perrito",
                style = MaterialTheme.typography.h5,
                color = Blanco,
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre", color = Blanco) },
                leadingIcon = { Icon(Icons.Filled.AccountCircle, contentDescription = null, tint = Blanco) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Blanco,
                    focusedBorderColor = Blanco,
                    unfocusedBorderColor = Blanco
                )
            )
            OutlinedTextField(
                value = raza,
                onValueChange = { raza = it },
                label = { Text("Raza", color = Blanco) },
                leadingIcon = { Icon(Icons.Filled.List, contentDescription = null, tint = Blanco) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Blanco,
                    focusedBorderColor = Blanco,
                    unfocusedBorderColor = Blanco
                )
            )
            OutlinedTextField(
                value = tamaño,
                onValueChange = { tamaño = it },
                label = { Text("Tamaño", color = Blanco) },
                leadingIcon = { Icon(Icons.Filled.Info, contentDescription = null, tint = Blanco) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Blanco,
                    focusedBorderColor = Blanco,
                    unfocusedBorderColor = Blanco
                )
            )
            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad", color = Blanco) },
                leadingIcon = { Icon(Icons.Filled.DateRange, contentDescription = null, tint = Blanco) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Blanco,
                    focusedBorderColor = Blanco,
                    unfocusedBorderColor = Blanco
                )
            )
            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("URL de la Foto", color = Blanco) },
                leadingIcon = { Icon(Icons.Filled.Add, contentDescription = null, tint = Blanco) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Blanco,
                    focusedBorderColor = Blanco,
                    unfocusedBorderColor = Blanco
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    datos.value = RegistroDatos(nombre, raza, tamaño, edad, url)
                    navController.navigate("screenB")
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(backgroundColor = Blanco)
            ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = AzulOscuro)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Registrar", color = AzulOscuro)
            }
        }
    }
}