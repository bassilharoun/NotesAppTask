package com.apps.yourspacekotlin.NotesApp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.apps.yourspacekotlin.NotesApp.model.Note
import com.apps.yourspacekotlin.databinding.DialogAddNoteBinding

class AddNoteDialog(context: Context,var addDialogListener: AddDialogListener) :AppCompatDialog(context){
    private lateinit var binding: DialogAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNote.setOnClickListener {

        var noteName = binding.etUrNote.text.toString()
            if (noteName.isEmpty()){
                Toast.makeText(context,"Where's Ur Note ??",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

        var item = Note(noteName)
            addDialogListener.onNoteButtonClicked(item)
            dismiss()
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }
}