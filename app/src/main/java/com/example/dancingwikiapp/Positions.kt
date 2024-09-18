package com.example.dancingwikiapp


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

data class Position(
    val name_official: String,
    val synonyms: List<String>
) : Searchable {

    override fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(name_official, "${name_official.first()}") + synonyms
        return matchingCombinations.any { it.contains(query, ignoreCase = true) }
    }
}




//Define some nomination rules for the Positions
val Positions = listOf(
    Position(
        name_official = "Primeira",
        synonyms = listOf("Pés em V", "Pés juntinhos", "Pés de porta")
    ),
    Position(name_official = "Segunda",
        synonyms = listOf("Pés afastados", "Pés abertos", "Pés de linha reta")

    ),

    Position(name_official = "Terceira",
        synonyms = listOf("Pés cruzados", "Meia quinta", "Posição intermediária", "PÉ DE PORCO")
    ),

    Position(name_official = "Quarta",
        synonyms = listOf("Um pé à frente", "Posição avançada", "Pés separados")
    ),

    Position(name_official = "Quinta",
        synonyms = listOf("Pés fechados", "Pés encaixados", "Cruz total")
    )

)