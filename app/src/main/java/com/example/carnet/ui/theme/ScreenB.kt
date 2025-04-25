package com.example.carnet.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var showEditDialog by remember { mutableStateOf(false) }
    var showDeleteConfirmation by remember { mutableStateOf(false) }

    // Variables de estado para los valores editables
    var name by remember { mutableStateOf(nombre) }
    var breed by remember { mutableStateOf(raza) }
    var size by remember { mutableStateOf(tamanio) }
    var age by remember { mutableStateOf(edad) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(White, RoundedCornerShape(16.dp))
                .padding(20.dp)
                .fillMaxWidth()
                .height(210.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(fotoUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .padding(end = 20.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Nombre: $name", fontSize = 20.sp, color = Black)
                Text("Raza: $breed", fontSize = 20.sp, color = Black)
                Text("Tamaño: $size", fontSize = 20.sp, color = Black)
                Text("Edad: $age años", fontSize = 20.sp, color = Black)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { showEditDialog = true },
            colors = ButtonDefaults.buttonColors(backgroundColor = LightBlue)
        ) {
            Icon(Icons.Default.Edit, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Editar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showDeleteConfirmation = true },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {
            Icon(Icons.Default.Delete, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Eliminar")
        }
    }

    if (showEditDialog) {
        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text(text = "Editar Información") },
            text = {
                Column {
                    Text("Edita la información a continuación:")

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nombre") }
                    )

                    TextField(
                        value = breed,
                        onValueChange = { breed = it },
                        label = { Text("Raza") }
                    )

                    TextField(
                        value = size,
                        onValueChange = { size = it },
                        label = { Text("Tamaño") }
                    )

                    TextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Edad") }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    showEditDialog = false
                }) {
                    Text("Guardar")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
    if (showDeleteConfirmation) {
        AlertDialog(
            onDismissRequest = { showDeleteConfirmation = false },
            title = { Text("Confirmar Eliminación") },
            text = { Text("¿Estás seguro que quieres eliminar este registro?") },
            confirmButton = {
                TextButton(onClick = {
                    showDeleteConfirmation = false
                    navController.popBackStack()
                }) {
                    Text("Sí, eliminar", color = Color.Red)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteConfirmation = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}