package com.example.dancingwikiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

val movement1 = Movements[1]
@Composable
fun AboutDanceScreen() {
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
                text = movement1.name_official,
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
                painter = rememberAsyncImagePainter(model = "https://cdn.usegalileo.ai/sdxl10/ee83b148-a8f2-4b17-8376-2fb7efdbbc03.png"),
                contentDescription = "Rond de Jambe Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Description
        Text(
            text = movement1.detailed_description,
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
                    text = movement1.synonyms.joinToString(", "),
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
                onClick = { /* Handle Details */ },
                modifier = Modifier.weight(1f).padding(end = 8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFeb47eb),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Details")
            }

            // Watch Video Buttoncava
            Button(
                onClick = { /* Handle Watch Video */ },
                modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFf4f0f4),
                    contentColor = Color(0xFF181118)
                )
            ) {
                Text(text = "Watch Video")
            }

            // More Photos Button
            Button(
                onClick = { /* Handle More Photos */ },
                modifier = Modifier.weight(1f).padding(start = 8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFf4f0f4),
                    contentColor = Color(0xFF181118)
                )
            ) {
                Text(text = "More Photos")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutDanceScreenPreview() {
    AboutDanceScreen()
}
