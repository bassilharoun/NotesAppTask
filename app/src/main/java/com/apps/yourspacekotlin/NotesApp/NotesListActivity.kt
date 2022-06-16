package com.apps.yourspacekotlin.NotesApp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.yourspacekotlin.NotesApp.model.Note
import com.apps.yourspacekotlin.NotesApp.utils.NotesAdapter
import com.apps.yourspacekotlin.R
import com.apps.yourspacekotlin.databinding.ActivityNotesListBinding

class NotesListActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNotesListBinding.inflate(layoutInflater)


            super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val noteListSingleItem = mutableListOf(Note("learn kotlin"))
        val adapter = NotesAdapter(noteListSingleItem)
        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = LinearLayoutManager(this)

        binding.floatingActionButton.setImageResource(R.drawable.ic_action_name)
        val newNote = EditText(this)
        binding.floatingActionButton.setOnClickListener {
            val noteDialog = AlertDialog.Builder(this)
                .setTitle("What's Ur Note ? :)")
                .setView(newNote)
                .setCancelable(false)
                .setPositiveButton("Note"){ dialogInterface : DialogInterface, i: Int ->
                        val newNoteText = newNote.text.toString()
                        val newNote = Note(newNoteText)
                        noteListSingleItem.add(newNote)
                        adapter.notifyDataSetChanged()


                }
                .setNegativeButton("Back"){ dialogInterface : DialogInterface, i: Int ->
                    dialogInterface.cancel()

                }
            val alertDialog = noteDialog.create()
            alertDialog.show()


        }
    }
}