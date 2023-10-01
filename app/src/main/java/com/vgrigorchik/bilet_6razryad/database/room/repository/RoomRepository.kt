package com.vgrigorchik.bilet_6razryad.database.room.repository

import androidx.lifecycle.LiveData
import com.vgrigorchik.bilet_6razryad.database.DatabaseRepository
import com.vgrigorchik.bilet_6razryad.database.room.dao.NoteRoomDao
import com.vgrigorchik.bilet_6razryad.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DatabaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNodes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
        onSuccess()
    }
}