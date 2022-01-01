package com.example.notepadapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.notepadapp.R
import com.example.notepadapp.controller.NoteController
import com.example.notepadapp.model.Note

class ActivityNewNote : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var noteController: NoteController
    private lateinit var editTextTittle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonSave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir_nota)

        noteController = NoteController(applicationContext)
        editTextTittle = findViewById(R.id.edit_text_title)
        editTextDescription = findViewById(R.id.edit_text_description)
        buttonSave = findViewById(R.id.button_save)
        toolbar = findViewById(R.id.toolbar)

        buttonSave.setOnClickListener {
            saveNote()
        }
        toolbar.setNavigationOnClickListener {
            this.onBackPressed()
        }

    }

    private fun saveNote(){
        val a = noteController.newNote(Note(tittle = editTextTittle.text.toString(), description = editTextDescription.text.toString()))
        Toast.makeText(this, "${a.id}", Toast.LENGTH_SHORT).show()
    }
}