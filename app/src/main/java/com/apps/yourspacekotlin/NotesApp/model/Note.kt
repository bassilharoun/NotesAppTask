package com.apps.yourspacekotlin.NotesApp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_items")
data class Note(@ColumnInfo(name = "note_title") var title:String) {

    @PrimaryKey(autoGenerate = true) var id:Int? = null
}