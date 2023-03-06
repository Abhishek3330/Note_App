package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.database.Note
import com.example.database.NoteDao
import com.example.database.NoteDatabase
import com.example.factory.NoteModelFactory
import com.example.noteapp.databinding.ActivityAddBinding
import com.example.repository.NoteRepository
import com.example.viewmodel.NoteViewModel

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var repository: NoteRepository
    private lateinit var noteDao: NoteDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDao = NoteDatabase.getInstance(this).noteDao()
        repository = NoteRepository(noteDao)

        noteViewModel = ViewModelProvider(
            this,
            NoteModelFactory(application, repository)
        )[NoteViewModel::class.java]

        binding.btnAddNote.setOnClickListener {
            if (binding.etTitle.text.trim().toString()
                    .isEmpty() && binding.etDescription.text.trim().toString()
                    .isEmpty()
            ) {
                return@setOnClickListener
            } else {
                val note = Note(
                    0,
                    binding.etTitle.text.trim().toString(),
                    binding.etDescription.text.trim().toString()
                )
                saveDb(note)
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NoteActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

    private fun saveDb(note: Note) {
        noteViewModel.insetNote(note)
    }


}