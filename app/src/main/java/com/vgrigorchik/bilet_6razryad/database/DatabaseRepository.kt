package com.vgrigorchik.bilet_6razryad.database

import androidx.lifecycle.LiveData
import com.vgrigorchik.bilet_6razryad.model.Note

interface DatabaseRepository {
    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: ()-> Unit)

    suspend fun update(note: Note, onSuccess: ()-> Unit)

    suspend fun delete(note: Note, onSuccess: ()-> Unit)

}