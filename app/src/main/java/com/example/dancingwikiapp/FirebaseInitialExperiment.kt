package com.example.dancingwikiapp

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
data class Movimento(
    val id: Int,
    val name_official: String,
    val synonyms: List<String>,
    val description: String,
    val grade: Int,
    val complexity: Int,
    val typo: String,
    val translation: String,
    val detailed_description: String,
    val related: List<String>,
    val methodical_description: String,
    val child_explanation: String,
    val imageUrl: String? = null,   // Add imageUrl to store Firebase image URLs
    val videoUrl: String? = null
)

val db = FirebaseFirestore.getInstance()

val movement = Movimento(
    id = 1,
    name_official = "Plié",
    synonyms = listOf("Dobrar", "Flexionar"),
    description = "Flexão dos joelhos em várias posições, foco em postura e alinhamento.",
    grade = 1,
    complexity = 1,
    typo = "Plie",
    translation = "Flexão",
    detailed_description = "O plié é um movimento fundamental no balé...",
    related = listOf("Postura", "Alinhamento"),
    methodical_description = "Para executar o plié, dobre os joelhos...",
    child_explanation = "No plié, você se agacha um pouquinho...",
    imageUrl = "https://yourfirebaseurl.com/plié.jpg",
    videoUrl = "https://yourfirebaseurl.com/plié.mp4"
)

fun addMovementToFirestore(movement: Movimento, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
    val db = FirebaseFirestore.getInstance()

    // Add movement to Firestore with an automatic document ID
    db.collection("movements")
        .add(movement)  // Automatically generates a unique document ID
        .addOnSuccessListener {
            println("Movement added successfully with ID: ${it.id}")
            onSuccess()  // Callback for success
        }
        .addOnFailureListener { e ->
            println("Failed to add movement: ${e.message}")
            onFailure(e)  // Callback for failure
        }
}







