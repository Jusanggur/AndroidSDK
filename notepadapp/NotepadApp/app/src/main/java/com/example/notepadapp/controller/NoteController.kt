package com.example.notepadapp.controller

import android.content.Context
import com.example.notepadapp.model.Note
import com.example.notepadapp.model.NoteDao

class NoteController(context: Context) {

    var noteDao = NoteDao(context)

    fun newNote(note: Note): Note {
        return noteDao.insertNote(note)
    }

    fun getNotes(): ArrayList<Note> {
       return noteDao.getListNotes()
    }
    fun getTittleNotes(): ArrayList<String>{
        val tittlesArrayList = ArrayList<String>()
        for (notes in getNotes()){
            tittlesArrayList.add(notes.tittle)
        }
        return tittlesArrayList
    }
    fun removeNote(id:Int){
        return noteDao.removeNote(id)
    }

    fun editNote(id: Int, title: String, description: String){
        return noteDao.editNote(id,title,description)
    }


}