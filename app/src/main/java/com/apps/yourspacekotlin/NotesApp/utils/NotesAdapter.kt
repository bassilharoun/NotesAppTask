package com.apps.yourspacekotlin.NotesApp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.yourspacekotlin.NotesApp.model.Note
import com.apps.yourspacekotlin.databinding.ActivityNotesListBinding
import com.apps.yourspacekotlin.databinding.ItemNoteBinding

class NotesAdapter(var notes:List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){

    inner class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            tvNote.text = notes[position].title
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}