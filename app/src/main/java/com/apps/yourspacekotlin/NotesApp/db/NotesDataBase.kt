package com.apps.yourspacekotlin.NotesApp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apps.yourspacekotlin.NotesApp.model.Note
import java.util.concurrent.locks.Lock

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun getNotesDao():NoteDao

    companion object{
        @Volatile
        private var instance: NotesDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: createDB(context).also {
                instance = it
            }

        }
        private  fun createDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NotesDataBase::class.java,
                "notesDB.dp"
            ).build()


    }

}