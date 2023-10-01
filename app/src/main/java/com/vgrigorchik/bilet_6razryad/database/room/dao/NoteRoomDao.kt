package com.vgrigorchik.bilet_6razryad.database.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vgrigorchik.bilet_6razryad.model.Note

@Dao
interface NoteRoomDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNodes(): LiveData<List<Note>>

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}