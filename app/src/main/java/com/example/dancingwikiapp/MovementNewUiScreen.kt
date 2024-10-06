package com.example.dancingwikiapp

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.rememberAsyncImagePainter

val movement1 = Movements[11]

@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
@Composable
fun SimpleVideoPlayer(videoUri: Uri) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
        }
    }

    DisposableEffect(
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                }
            },
            modifier = Modifier.fillMaxWidth().height(250.dp)
        )
    ) {
        onDispose { exoPlayer.release() }
    }
}
@Composable
fun AboutDanceScreen(movement: Movement) {
    val selectedButton = remember { mutableStateOf("Detalhes") }
    Spacer(modifier = Modifier.height(16.dp))
    Spacer(modifier = Modifier.height(32.dp))
    Spacer(modifier = Modifier.height(32.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Top Bar with Back Button and Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Back Arrow Icon
            Icon(
                painter = painterResource(id = android.R.drawable.ic_media_previous),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* handle back click */ },
                tint = Color.Black
            )

            // Title
            Text(
                text = movement.name_official,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF181118),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

        }

        // Image Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(218.dp)
                .background(Color.LightGray) // Placeholder color while loading
        ) {
            Image(
                painter = painterResource(id = R.drawable.teste1),
                contentDescription = "Rond de Jambe Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Description
        Text(
            text = movement.detailed_description,
            color = Color(0xFF181118),
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // Additional Information
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Também conocido como:",
                    color = Color(0xFF181118),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                Text(
                    text = movement.synonyms.joinToString(", "),
                    color = Color(0xFF886388),
                    fontSize = 14.sp
                )
            }
        }

        // Buttons Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Details Button
            Button(
                onClick = { selectedButton.value = "Detalhes" },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton.value == "Detalhes") Color(0xFFeb47eb) else Color(0xFFf4f0f4),
                    contentColor = if (selectedButton.value == "Detalhes") Color.White else Color(0xFF181118)
                )
            ) {
                Text(text = "Detalhes")
            }

            // Watch Video Buttoncava
            Button(
                onClick = { selectedButton.value = "Vídeo" },
                modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton.value == "Vídeo") Color(0xFFeb47eb) else Color(0xFFf4f0f4),
                    contentColor = if (selectedButton.value == "Vídeo") Color.White else Color(0xFF181118)
                )
            ) {
                Text(text = "Vídeo")
            }

            // More Photos Button
            Button(
                onClick = { selectedButton.value = "Fotos" },
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = if (selectedButton.value == "Fotos") Color(0xFFeb47eb) else Color(0xFFf4f0f4),
                    contentColor = if (selectedButton.value == "Fotos") Color.White else Color(0xFF181118)
                )
            ) {
                Text(text = "Fotos")
            }
        }
        when (selectedButton.value) {
            "Detalhes" -> {
                // Display details content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text(
                        text = movement.methodical_description,
                        color = Color.DarkGray,
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

            }


            "Vídeo" -> {
                // Show video player
                val context = LocalContext.current
                val packageName =context.packageName
                val videoUri = Uri.parse("android.resource://$$packageName/${R.raw.pirouette_video}") // Replace with your video URI
                SimpleVideoPlayer(videoUri = videoUri)
            }

            "Fotos" -> {
                // Display photo gallery
                Text(text = "Showing Fotos...")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutDanceScreenPreview() {
    AboutDanceScreen(movement1)
}
