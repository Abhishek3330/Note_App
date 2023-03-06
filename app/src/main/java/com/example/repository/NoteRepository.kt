package com.example.repository

import androidx.lifecycle.LiveData
import com.example.database.Note
import com.example.database.NoteDao

/**
 * Created by Mukesh on 03-03-2023.
 */
class NoteRepository(private val notesDao: NoteDao) {

    fun getNote(): LiveData<List<Note>> {
        return notesDao.getAllNote()
    }

    suspend fun insertNote(note: Note) {
        notesDao.insetNote(note)
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(note)
    }

    suspend fun updateNote(note: Note) {
        notesDao.updateNote(note)
    }
    suspend fun deleteById(noteId: Int) {
        notesDao.deleteNoteById(noteId)
    }
}