package com.example.dancingwikiapp.newuimovement



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.dancingwikiapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // Variable to store the currently selected section (default to "home")
    var selectedSection by remember { mutableStateOf("details") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rond de Jambe") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding: PaddingValues ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // Adding a spacer to create space below the TopAppBar

            // Image section
            Image(
                painter = rememberImagePainter("https://cdn.usegalileo.ai/sdxl10/ee83b148-a8f2-4b17-8376-2fb7efdbbc03.png"),
                contentDescription = "Ballet image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Text description section
            Text(
                text = "A term of the Cecchetti method. It is a movement in which the extended leg describes a half circle.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Also known as",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = "Circular movements",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Buttons section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { selectedSection = "details" },
                    colors = ButtonDefaults.buttonColors(containerColor = if (selectedSection == "details") Color(0xFFeb47eb) else Color(0xFFF4F0F4)
                    )
                ) {
                    Text(
                        "Detalhes",
                        color = if (selectedSection == "details") Color.White else Color.Black
                    )
                }
                Button(
                    onClick = { selectedSection = "video" },
                    colors = ButtonDefaults.buttonColors(containerColor = if (selectedSection == "video") Color(0xFFeb47eb) else Color(0xFFF4F0F4)
                    )
                ) {
                    Text(
                        "Video",
                        color = if (selectedSection == "video") Color.White else Color.Black
                    )
                }
                Button(
                    onClick = { selectedSection = "photos" },
                    colors = ButtonDefaults.buttonColors(containerColor = if (selectedSection == "photos") Color(0xFFeb47eb) else Color(0xFFF4F0F4)
                    )
                ) {
                    Text(
                        "Fotos",
                        color = if (selectedSection == "photos") Color.White else Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Content based on selected section
            when (selectedSection) {
                "details" -> DetailsContent()
                "video" -> VideoContent()
                "photos" -> PhotosContent()
                else -> HomeContent() // Default content when "home" or no section is selected
            }
        }
    }
}

@Composable
fun HomeContent() {
    // Additional content for the home section can be added here
    Text(
        text = "Welcome to the home section!",
        modifier = Modifier.padding(horizontal = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun DetailsContent() {
    Text(
        text = "Details about Rond de Jambe",
        modifier = Modifier.padding(horizontal = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun VideoContent() {
    Text(
        text = "Watch a video demonstration",
        modifier = Modifier.padding(horizontal = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Composable
fun PhotosContent() {
    Text(
        text = "More photos of Rond de Jambe",
        modifier = Modifier.padding(horizontal = 16.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
