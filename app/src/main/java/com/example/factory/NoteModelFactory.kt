package com.example.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repository.NoteRepository
import com.example.viewmodel.NoteViewModel

/**
 * Created by Mukesh on 04-03-2023.
 */
class NoteModelFactory(val application: Application, private val noteRepository: NoteRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(application, noteRepository) as T

        }
        return super.create(modelClass)
    }

}



//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
//            return NoteViewModel(application,noteRepository) as T
//        }
//        throw IllegalArgumentException("Unknown View Model class")
//    }
//}