package com.apps.yourspacekotlin.NotesApp.repository

import com.apps.yourspacekotlin.NotesApp.db.NotesDataBase
import com.apps.yourspacekotlin.NotesApp.model.Note

class NotesRepository(private val db:NotesDataBase) {

    suspend fun upsert(item: Note) = db.getNotesDao().upsert(item)
    suspend fun delete(item: Note) = db.getNotesDao().delete(item)
    fun getAllNotes() = db.getNotesDao().getAllNotes()
}