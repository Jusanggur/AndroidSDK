package com.example.notepadapp.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class NoteDao(context: Context) {

    var database: SQLiteDatabase = context.openOrCreateDatabase("dbNotas", Context.MODE_PRIVATE, null).apply {
        execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT,tittle varchar,description varchar)")
    }

    fun insertNote(note: Note): Note {
        val contentValues = ContentValues().apply {
            put("tittle", note.tittle)
            put("description", note.description)
        }
        val id = database.insert("notas", null, contentValues)
        note.id = id.toInt()
        return note
    }

    fun getListNotes(): ArrayList<Note> {
        val cursor = database.rawQuery("SELECT * FROM notas", null)
        cursor.moveToFirst()
        val arrayList = ArrayList<Note>()
        while (!cursor.isAfterLast) {
            arrayList.add(
                Note(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
                )
            )
            cursor.moveToNext()
        }
        return arrayList
    }

    fun removeNote(id: Int) {
        database.delete("notas", "id = ${id}", null)
    }

    fun editNote(id: Int, tittle: String, description: String) {
        val contentValues = ContentValues().apply {
            put("tittle", tittle)
            put("description", description)
        }
        database.update("notas", contentValues, "id=${id}", null)
    }


}