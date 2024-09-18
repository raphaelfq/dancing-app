package com.example.dancingwikiapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn

//For learning purposes, I created a generic ViewModel for searching mechanism, since we are going to have 2 searching screens, each one
// operating in 2 differents data classes: Positions and Movements. Even though both dataclasses have the exactly same structure and types of data,
// I found the creation of a generic ViewModel a good exercise for practicing modularization and reusability of code via decoupling

//Searchable interface: This interface ensures that any data class you want to use with the search functionality has a doesMatchSearchQuery method.
//Generic SearchViewModel: This ViewModel now works with any type T that implements Searchable.
//setItems function: This function allows you to set the initial list of items to be searched.
//This approach makes your search functionality reusable and adaptable for different data types.
// You can easily add new searchable data classes by implementing the Searchable interface.
class SearchViewModel<T: Searchable> : ViewModel() {
    //Input that will be typed text in the search

    private val _searchText = MutableStateFlow("") //MutableStateFlow is a type of flow in Kotlin coroutines that holds a single mutable value and emits updates to its collectors whenever the value changes.
    val searchText = _searchText.asStateFlow()

    //Manages the state of _searchText, granting that in the case of a change in the search text, the variable will be updated
    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

    private val _itemsSearched = MutableStateFlow<List<T>>(emptyList())
    //Transfers the current Data for the construction of the viewmodel instatiated in the moment of the currently ViewModel Definition
    //It's like passing the respectively list of objects to the viewmodel being created, the parameters necessary for its creation in the moment of its construction
    fun setItems(items: List<T>){
        _itemsSearched.value = items
    }

    val itemsSearched = searchText.debounce(500L).combine(_itemsSearched) { text, items ->
        if (text.isBlank()) {
            items
        } else {
            items.filter { it.doesMatchSearchQuery(text) }
        }
    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _itemsSearched.value)

}