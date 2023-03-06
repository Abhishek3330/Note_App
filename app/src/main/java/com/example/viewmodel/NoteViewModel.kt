package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.database.Note
import com.example.database.NoteDatabase
import com.example.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Mukesh on 03-03-2023.
 */
class NoteViewModel(application: Application, private var noteRepository: NoteRepository) :
    ViewModel() {


    val allNotes: LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getInstance(application).noteDao()
        noteRepository = NoteRepository(dao)
        allNotes = noteRepository.getNote()
    }

    fun getNote(): LiveData<List<Note>> {
        return noteRepository.getNote()
    }

    fun insetNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.insertNote(note)
        }
    }

    fun upDateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNote(note)
        }
    }
    fun deleteEventById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteById(id)
        }
    }


}