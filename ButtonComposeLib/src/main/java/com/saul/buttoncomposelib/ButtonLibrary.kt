package com.saul.buttoncomposelib

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ButtonLibraryComposable() {
    var showAlert by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            showAlert = true
        }) {
            Text("Mostrar Alerta")
        }

        MyAlert(showAlert, onDismiss = { showAlert = false }, context)
    }
}

@Composable
fun MyAlert(showAlert: Boolean, onDismiss: () -> Unit, context: Context) {
    if (showAlert) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text("Advertencia") },
            text = { Text("Al pulsar aceptar se borraran todos los datos") },
            confirmButton = {
                Button(onClick = {
                    onDismiss()
                    Toast.makeText(context, "Datos eliminados.", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
