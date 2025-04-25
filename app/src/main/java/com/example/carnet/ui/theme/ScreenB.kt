package com.example.carnet.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter


val poppinsB = FontFamily.Default

@Composable
fun ScreenB(
    nombre: String,
    raza: String,
    tamanio: String,
    edad: String,
    fotoUrl: String,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(White, RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(fotoUrl),
                    contentDescription = "Foto de la mascota",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 16.dp)
                )

                Column {
                    Text("Nombre: $nombre", fontSize = 18.sp, fontFamily = poppinsB, color = Black)
                    Text("Raza: $raza", fontSize = 18.sp, fontFamily = poppinsB, color = Black)
                    Text("Tamaño: $tamanio", fontSize = 18.sp, fontFamily = poppinsB, color = Black)
                    Text("Edad: $edad años", fontSize = 18.sp, fontFamily = poppinsB, color = Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { navController.navigate("screen_a") },
                colors = ButtonDefaults.buttonColors(backgroundColor = White)
            ) {
                Text("Registrar Nueva Mascota", color = DarkBlue)
            }
        }
    }
}