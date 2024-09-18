import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dancingwikiapp.Movement
import com.example.dancingwikiapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovementCard(movement: Movement) {
    var showDetailedDescription by remember { mutableStateOf(false) }
    var showMedia by remember { mutableStateOf(false) }
    var showKidsExplanation by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {
                Text(
                    text = movement.name_official,
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
                val context = LocalContext.current
                val mediaPlayer = remember { MediaPlayer() }
                val playAudio = {
                    if (mediaPlayer.isPlaying) {
                        mediaPlayer.pause()
                    } else {
                        mediaPlayer.reset()
                        // Substitua pelo caminho do seu arquivo de áudio
                        val audioFile = context.assets.openFd("pronunciation_plie.mp3")
                        mediaPlayer.setDataSource(audioFile.fileDescriptor, audioFile.startOffset, audioFile.length)
                        mediaPlayer.setAudioAttributes(
                            AudioAttributes.Builder()
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .build()
                        )
                        mediaPlayer.prepare()
                        mediaPlayer.start()
                    }
                }
                IconButton(onClick = playAudio) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_play_arrow),
                        contentDescription = "Play audio",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Imagem Oficial
            Image(
                painter = painterResource(id = R.drawable.imagim),
                contentDescription = "Imagem do movimento",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )

            // Sinônimos
            Spacer(modifier = Modifier.height(8.dp))
            if (movement.synonyms.isNotEmpty()) {
                Text(
                    text = "Sinônimos:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    movement.synonyms.forEachIndexed { index, synonym ->
                        Text(
                            text = if (index == movement.synonyms.lastIndex) synonym else "$synonym, ",
                            modifier = Modifier.padding(end = 4.dp),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Descrição
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Descrição:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = movement.description,
                fontSize = 17.sp,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (movement.synonyms.isNotEmpty()) {
                Text(
                    text = "Habilidades Relacionadas:",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${movement.related.joinToString(", ")}")
                Spacer(modifier = Modifier.height(8.dp))
            }



            // Dificuldade e Nível
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Índices:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Complexidade: ${movement.complexity}",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Nível: ${movement.grade}",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            // Seções Expansíveis (com Card e Column)
            Spacer(modifier = Modifier.height(16.dp))
            // Descrição Detalhada
            Button(
                onClick = { showDetailedDescription = !showDetailedDescription },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = if (showDetailedDescription) "Ocultar Descrição Detalhada" else "Mostrar Descrição Detalhada"
                )
            }
            if (showDetailedDescription) {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = movement.detailed_description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Mídias
            Button(
                onClick = { showMedia = !showMedia },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = if (showMedia) "Ocultar Mídias" else "Mostrar Mídias"
                )
            }
            if (showMedia) {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // Implemente a exibição de mídias aqui (vídeos, imagens, etc.)
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.aguarde_em_breve),
                            contentDescription = "Imagem do movimento",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .padding(bottom = 16.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.aguarde_em_breve),
                            contentDescription = "Imagem do movimento",
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .padding(bottom = 16.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Explicação Lúdica
            Button(
                onClick = { showKidsExplanation = !showKidsExplanation },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = if (showKidsExplanation) "Ocultar Explicação Lúdica" else "Mostrar Explicação Lúdica"
                )
            }
            if (showKidsExplanation) {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = movement.child_explanation,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}