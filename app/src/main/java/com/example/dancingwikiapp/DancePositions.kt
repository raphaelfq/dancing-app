package com.example.dancingwikiapp
import com.example.dancingwikiapp.R


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class DanceMovement(val name: String, val id: Int, val description: String, val imageResourceId: Int)

val primeira = DanceMovement("Primeira Posição", 1,
    "Os braços devem ser posicionados formando um círculo na altura do umbigo...",
    R.drawable.primeira_posicao
)
val segunda = DanceMovement("Segunda Posição", 2,
    "Os braços devem ser posicionados formando um círculo na altura do umbigo...",
    R.drawable.segunda_posicao
)
val terceira = DanceMovement("Terceira Posição", 3,
    "Os braços devem ser posicionados formando um círculo na altura do umbigo...",
    R.drawable.terceira_posicao
)
val quarta = DanceMovement("Quarta Posição", 4,
    "Os braços devem ser posicionados formando um círculo na altura do umbigo...",
    R.drawable.terceira_posicao
)

val quinta = DanceMovement("Quartaixfeirax Posição", 5,
    "Os braços devem ser posicionados formando um círculo na altura do umbigo...",
    R.drawable.terceira_posicao
)