package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.NoteAdapter
import com.example.database.Note
import com.example.database.NoteDao
import com.example.database.NoteDatabase
import com.example.factory.NoteModelFactory
import com.example.noteapp.databinding.ActivityNoteBinding
import com.example.repository.NoteRepository
import com.example.viewmodel.NoteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteBinding
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var repository: NoteRepository
    private lateinit var noteDao: NoteDao
    private lateinit var adapter: NoteAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.recyclerview)

        binding.floatingBtn.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            finish()

        }

        noteDao = NoteDatabase.getInstance(this).noteDao()
        repository = NoteRepository(noteDao)

        noteViewModel = ViewModelProvider(
            this,
            NoteModelFactory(application, repository)
        )[NoteViewModel::class.java]

        NoteDatabase.getInstance(this).noteDao().getAllNote().observe(this, Observer {
            setDataRecyclerView(it)
        })



    }

    private fun setDataRecyclerView(notes: List<Note>) {
        adapter = NoteAdapter(notes)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


}