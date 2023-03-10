package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
)
