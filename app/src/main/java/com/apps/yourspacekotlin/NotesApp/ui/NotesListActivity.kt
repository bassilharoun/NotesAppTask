package com.apps.yourspacekotlin.NotesApp.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.yourspacekotlin.NotesApp.db.NotesDataBase
import com.apps.yourspacekotlin.NotesApp.model.Note
import com.apps.yourspacekotlin.NotesApp.repository.NotesRepository
import com.apps.yourspacekotlin.NotesApp.ui.utils.NotesAdapter
import com.apps.yourspacekotlin.R
import com.apps.yourspacekotlin.databinding.ActivityNotesListBinding

class NotesListActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNotesListBinding.inflate(layoutInflater)


            super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var database = NotesDataBase(this)
        val repository = NotesRepository(database as NotesDataBase)
        val factory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(NotesViewModel::class.java)

        val noteListSingleItem = mutableListOf(Note("learn kotlin"))
        val adapter = NotesAdapter(listOf(),viewModel)
        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = LinearLayoutManager(this)

        viewModel.getAllNotes().observe(this, Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })

        binding.floatingActionButton.setOnClickListener {
            AddNoteDialog(this , object :AddDialogListener{
                override fun onNoteButtonClicked(item: Note) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}