package com.example.carnet.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val poppins = FontFamily.Default
@Composable
fun ScreenA(
    nombre: MutableState<String>,
    raza: MutableState<String>,
    tamanio: MutableState<String>,
    edad: MutableState<String>,
    fotoUrl: MutableState<String>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registro de Mascota", color = White, fontSize = 26.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(24.dp))

        val fieldModifier = Modifier
            .fillMaxWidth()
            .background(White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .padding(4.dp)

        OutlinedTextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre") },
            leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            modifier = fieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = White,
                textColor = Black,
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = raza.value,
            onValueChange = { raza.value = it },
            label = { Text("Raza") },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) },
            modifier = fieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
               backgroundColor = White,
                textColor = Black,
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = tamanio.value,
            onValueChange = { tamanio.value = it },
            label = { Text("Tamaño") },
            leadingIcon = { Icon(Icons.Default.Settings, contentDescription = null) },
            modifier = fieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = White,
                textColor = Black,
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = edad.value,
            onValueChange = { edad.value = it },
            label = { Text("Edad") },
            leadingIcon = { Icon(Icons.Default.DateRange, contentDescription = null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = fieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor =  White,
                textColor = Black,
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = fotoUrl.value,
            onValueChange = { fotoUrl.value = it },
            label = { Text("URL de la Foto") },
            leadingIcon = { Icon(Icons.Default.Add, contentDescription = null) },
            modifier = fieldModifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = White,
                textColor = Black,
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("screen_b") },
            colors = ButtonDefaults.buttonColors(backgroundColor =  LightBlue)
        ) {
            Icon(Icons.Default.Check, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Registrar")
        }
    }
}