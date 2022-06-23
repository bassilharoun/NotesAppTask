package com.apps.yourspacekotlin.NotesApp.ui

import com.apps.yourspacekotlin.NotesApp.model.Note

interface AddDialogListener {
    fun onNoteButtonClicked(item : Note)
}