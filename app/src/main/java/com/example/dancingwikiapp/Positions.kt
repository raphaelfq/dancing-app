package com.example.dancingwikiapp


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

class PositionsSearchViewModel: ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _persons = MutableStateFlow(Positions)
    val persons = searchText
        .debounce(750L)
        .combine(_persons){ text, persons ->
            if(text.isBlank()){
                persons
            }
            else{
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _persons.value
        )

    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

}

data class Position(
    val name_official: String,
    val synonyms: List<String>
) {
    fun doesMatchSearchQuery(query: String):Boolean {
        val matchingCombinations = listOf(
            name_official,
            "${name_official.first()}") + synonyms
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}


//Define some nomination rules for the Positions
private val Positions = listOf(
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