package com.example.dancingwikiapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UploadMovementScreen() {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isUploading by remember { mutableStateOf(false) }
    var uploadResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Movement Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isUploading = true // Set uploading state to true
                val movement = Movimento(
                    id = 1,
                    name_official = name,
                    synonyms = listOf("Dobrar", "Flexionar"),
                    description = description,
                    grade = 1,
                    complexity = 1,
                    typo = "Plie",
                    translation = "Flexão",
                    detailed_description = "O plié é um movimento fundamental no balé...",
                    related = listOf("Postura", "Alinhamento"),
                    methodical_description = "Para executar o plié, dobre os joelhos...",
                    child_explanation = "No plié, você se agacha um pouquinho...",
                    imageUrl = null,
                    videoUrl = null
                )

                // Call the upload function
                uploadMovement(movement,
                    onSuccess = {
                        isUploading = false // Reset the uploading state on success
                        uploadResult = "Movement uploaded successfully!"
                    },
                    onFailure = { e ->
                        isUploading = false // Reset the uploading state on failure
                        uploadResult = "Error uploading movement: ${e.message}"
                    }
                )
            },
            enabled = !isUploading, // Disable button while uploading
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = if (isUploading) "Uploading..." else "Upload Movement")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display upload result message
        uploadResult?.let {
            Text(text = it)
        }
    }
}

fun uploadMovement(movement: Movimento, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
    // Assuming addMovementToFirestore is defined properly
    addMovementToFirestore(
        movement,
        onSuccess = {
            // Reset UI on success
            onSuccess()
        },
        onFailure = { e ->
            // Reset UI on failure
            onFailure(e)
        }
    )
}


@Preview(showBackground = true)
@Composable
fun UploadMovementScreenPreview() {
    UploadMovementScreen()
}
