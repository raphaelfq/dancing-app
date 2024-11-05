package com.example.dancingwikiapp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

@Composable
fun UploadMovementScreen() {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isUploading by remember { mutableStateOf(false) }
    var uploadResult by remember { mutableStateOf<String?>(null) }
    var imageUrl by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()

    // Image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            imageUri = uri // Set the selected image URI
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Contribua com nossa database!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Este é um espaço para você contribuir com nossa database colaborativa de Balé fazendo o upload de um movimento que você acha interessante." +
                    "Determine o nome do movimento, forneça uma breve descrição (opcional), escolha uma imagem de referência e faça sua contribuição!",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome do Movimento") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descrição breve (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to pick an image
        Button(onClick = { imagePickerLauncher.launch("image/*") }) {
            Text("Escolha uma imagem (opcional)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display the selected image (if any)
        imageUri?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isUploading = true // Set uploading state to true

                // Check if an image was selected
                if (imageUri != null) {
                    // If image is selected, upload it to Firebase Storage
                    uploadImageToFirebaseStorage(imageUri!!, name,
                        onSuccess = { url ->
                            imageUrl = url
                            // After image is uploaded, upload the movement to Firestore
                            val movement = Movimento(
                                id = 1,
                                name_official = name,
                                synonyms = emptyList(),
                                description = description,
                                grade = 1,
                                complexity = 1,
                                typo = "",
                                translation = "",
                                detailed_description = "",
                                related = emptyList(),
                                methodical_description = "",
                                child_explanation = "",
                                imageUrl = url, // Image URL from Firebase Storage
                                videoUrl = null
                            )

                            uploadMovement(movement,
                                onSuccess = {
                                    isUploading = false
                                    uploadResult = "Upload da imagem feito com sucesso!!!"
                                },
                                onFailure = { e ->
                                    isUploading = false
                                    uploadResult = "Erro ao enviar o movimento: ${e.message}"
                                }
                            )
                        },
                        onFailure = { e ->
                            isUploading = false
                            uploadResult = "Erro ao enviar a imagem: ${e.message}"
                        }
                    )
                } else {
                    // If no image is selected, just upload the movement without an image URL
                    val movement = Movimento(
                        id = 1,
                        name_official = name,
                        synonyms = emptyList(),
                        description = description,
                        grade = 1,
                        complexity = 1,
                        typo = "",
                        translation = "",
                        detailed_description = "",
                        related = emptyList(),
                        methodical_description = "",
                        child_explanation = "",
                        imageUrl = null, // No image URL
                        videoUrl = null
                    )

                    uploadMovement(movement,
                        onSuccess = {
                            isUploading = false
                            uploadResult = "Movimento enviado com sucesso!"
                        },
                        onFailure = { e ->
                            isUploading = false
                            uploadResult = "Erro ao enviar o movimento: ${e.message}"
                        }
                    )
                }
            },
            enabled = !isUploading, // Disable button while uploading
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = if (isUploading) "Enviando..." else "Enviar movimento")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display upload result message
        uploadResult?.let {
            Text(text = it)
        }
    }
}

fun uploadMovement(movement: Movimento, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
    val db = FirebaseFirestore.getInstance()

    db.collection("movements")
        .add(movement)
        .addOnSuccessListener {
            onSuccess()
        }
        .addOnFailureListener { e ->
            onFailure(e)
        }
}

fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    fileName: String,
    onSuccess: (String) -> Unit,
    onFailure: (Exception) -> Unit
) {
    val storageRef = FirebaseStorage.getInstance().reference.child("images/$fileName.jpg")

    storageRef.putFile(imageUri)
        .addOnSuccessListener {
            storageRef.downloadUrl.addOnSuccessListener { uri ->
                onSuccess(uri.toString()) // Return the download URL
            }
        }
        .addOnFailureListener { exception ->
            onFailure(exception) // Handle any errors
        }
}

@Preview(showBackground = true)
@Composable
fun UploadMovementScreenPreview() {
    UploadMovementScreen()
}
