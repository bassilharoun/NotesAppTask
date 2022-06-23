package com.apps.yourspacekotlin.NotesApp.ui

import androidx.lifecycle.ViewModel
import com.apps.yourspacekotlin.NotesApp.model.Note
import com.apps.yourspacekotlin.NotesApp.repository.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository):ViewModel() {

    fun upsert(item :Note) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsert(item)
    }
    fun delete(item: Note) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }
    fun getAllNotes() = repository.getAllNotes()
}