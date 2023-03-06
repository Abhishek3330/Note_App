package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by Mukesh on 03-03-2023.
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insetNote( note: Note)

    @Delete
   suspend fun deleteNote(note: Note)

    @Update
   suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes")
    fun getAllNote(): LiveData<List<Note>>

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNoteById(id: Int)
}