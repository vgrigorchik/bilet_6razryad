package com.vgrigorchik.bilet_6razryad

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.vgrigorchik.bilet_6razryad.database.room.AppRoomDatabase
import com.vgrigorchik.bilet_6razryad.database.room.repository.RoomRepository
import com.vgrigorchik.bilet_6razryad.model.Note
import com.vgrigorchik.bilet_6razryad.utils.REPOSITORY
import com.vgrigorchik.bilet_6razryad.utils.TYPE_FIREBASE
import com.vgrigorchik.bilet_6razryad.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel (application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(type: String, onSuccess: ()-> Unit) {
        Log.d("checkDate", "MainViewModel initDatabase with type $type")
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }

    fun addNote(note: Note, onSuccess: () -> Unit) {
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.create(note = note) {
                viewModelScope.launch(Dispatchers.Main) {
                    onSuccess()
                }
            }
        }
    }

    fun readAllNotes() = REPOSITORY.readAll
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException ("Unknown ViewModel Class")
    }
}