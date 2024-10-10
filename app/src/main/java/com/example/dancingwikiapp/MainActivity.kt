package com.example.dancingwikiapp

import MovementCard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.dancingwikiapp.newuimovement.HomeScreen
import com.google.firebase.FirebaseApp


val LightColors = lightColorScheme(
    surface = Color(0xFFDF63D8), // Your desired surface color
    // You can also override other colors here
)

@Composable
fun CustomTheme(colors: ColorScheme, content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = colors, content = content)
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTheme(LightColors) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FirebaseApp.initializeApp(this)

                    UploadMovementScreen()




                }
            }
        }
    }
}