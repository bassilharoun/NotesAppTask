package com.apps.yourspacekotlin.NotesApp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apps.yourspacekotlin.NotesApp.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(item: Note)
    @Delete
    fun delete(item: Note)
    @Query("SELECT * FROM note_items")
    fun getAllNotes():LiveData<List<Note>>
}