package com.example.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.database.Note
import com.example.database.NoteDao
import com.example.database.NoteDatabase
import com.example.noteapp.R
import com.example.repository.NoteRepository
import com.example.viewmodel.NoteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Mukesh on 04-03-2023.
 */
class NoteAdapter(private val noteList: List<Note>):RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewTitle.text = noteList[position].title
        holder.textViewDescription.text = noteList[position].description
        holder.delete.setOnClickListener {

        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val textViewTitle: TextView = itemView.findViewById(R.id.tv_title)
        val textViewDescription: TextView = itemView.findViewById(R.id.tv_description)
        val delete: ImageView = itemView.findViewById(R.id.delete)



    }

}





