package com.example.carnet.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.carnet.RegistroDatos
@Composable
fun ScreenB(datos: RegistroDatos) {
    Surface(color = AzulOscuro, modifier = Modifier.fillMaxSize()) {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = GrisClaro,
            elevation = 12.dp,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(datos.urlImagen),
                    contentDescription = "Foto del perrito",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(end = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Nombre: ${datos.nombre}", color = Negro, style = MaterialTheme.typography.body1)
                    Text("Raza: ${datos.raza}", color = Negro, style = MaterialTheme.typography.body1)
                    Text("Tamaño: ${datos.tamaño}", color = Negro, style = MaterialTheme.typography.body1)
                    Text("Edad: ${datos.edad}", color = Negro, style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}