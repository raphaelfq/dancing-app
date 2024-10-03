package com.example.dancingwikiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun AboutUsScreen() {
    val scrollState = rememberScrollState()




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F5F9))
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(32.dp))
        Spacer(modifier = Modifier.height(32.dp))


//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = "About Us",
//                style = TextStyle(
//                    color = Color(0xFF0E141B),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp
//                ),
//                modifier = Modifier.weight(1f),
//                textAlign = androidx.compose.ui.text.style.TextAlign.Center
//            )
//            Button(
//                onClick = { /* Close button action */ },
//                modifier = Modifier.size(36.dp),
//                contentPadding = PaddingValues(0.dp)
//            ) {
//                Icon(
//                    painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
//                    contentDescription = "Close"
//                )
//            }
//        }

        Spacer(modifier = Modifier.height(16.dp))

        // Section: Meet the Team
        Text(
            text = "Conheça o time",
            style = TextStyle(
                color = Color(0xFF0E141B),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Team members
        TeamMember(
            imageUrl = "https://media.licdn.com/dms/image/v2/D4D03AQGUNkKT4gpZzw/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1667377634904?e=1733356800&v=beta&t=35yT8hTvPYx64g27wgg-5r9VaPTcwK29PJlxJ3GzWaA",
            name = "Raphael",
            description = "Desenvolvedor e Gerente",
            details = "Aluno de Engenharia da Computação na Unicamp e AI Software Developer @ Samsung Research Brazil."
        )

        Spacer(modifier = Modifier.height(16.dp))

        TeamMember(
            imageUrl = "https://media.licdn.com/dms/image/v2/D4E03AQHkrCrOiEdknw/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1704734279985?e=1733356800&v=beta&t=rg1pexrndESua9tH5PRWPnngqvKVdUx_mrarKxLe6Hg",
            name = "Pietra",
            description = "Especialista em Dança",
            details = "Porca, Artista, Neurocientista e Professora de Dança, responsável pela pesquisa [O papel da neuromotricidade na aprendizagem de Balé Clássico por crianças de 7 a 10 anos] "
        )

        Spacer(modifier = Modifier.height(16.dp))

        TeamMember(
            imageUrl = "https://scontent.fcpq5-1.fna.fbcdn.net/v/t1.6435-9/61588550_2361077177315393_4834633441435713536_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=53a332&_nc_eui2=AeFMbr7HXdq9i0AQb-5o-BTOmrF24gPbWRmasXbiA9tZGW1K-74jtOaToPMHuAU0aBlCq3lxHPedTm3Qxh4RkB9u&_nc_ohc=Ih3_GZ9Wx2cQ7kNvgHokEjF&_nc_ht=scontent.fcpq5-1.fna&_nc_gid=A6rXg0T_EokrlPdGOZphQwz&oh=00_AYB7eMyaW21piw5GlewWyynSral20MtjBLDBYykJwRAGDg&oe=67269F29",
            name = "Gabi",
            description = "Especialista em Dança",
            details = "Professora de Dança e responsável pela pesquisa [Um estudo do vocabulário presente em aulas de balé em perspectivas de tradução (francês-português) como meio para compreender as ações implicadas na técnica.]"
        )

        Spacer(modifier = Modifier.height(32.dp))

        TeamMember(
            imageUrl = "https://servicosweb.cnpq.br/wspessoa/servletrecuperafoto?tipo=1&id=K4769681J4",
            name = "Mariana",
            description = "Mentora",
            details = "Professora Associada I (Livre-Docente) do Departamento de Artes Corporais do Instituto de Artes da Unicamp."
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun TeamMember(imageUrl: String, name: String, description: String, details: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(128.dp)
                .background(Color.LightGray, shape = CircleShape)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            style = TextStyle(
                color = Color(0xFF0E141B),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
        Text(
            text = description,
            style = TextStyle(
                color = Color(0xFF4E7397),
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = details,
            style = TextStyle(
                color = Color(0xFF0E141B),
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}
@Preview(showBackground = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen()
}