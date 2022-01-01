package com.example.notepadapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notepadapp.R
import com.example.notepadapp.adapter.CustomAdapter
import com.example.notepadapp.controller.NoteController

class MainActivity : AppCompatActivity() {

    private lateinit var noteController: NoteController
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun newNote() {
        val intent = Intent(this, ActivityNewNote::class.java).apply {
            putExtra("id_note", 0)
        }
        startActivity(intent)
    }

    private fun excludeNote(id: Int) {
        noteController.removeNote(id)
    }

    private fun showNotes() {

    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        noteController = NoteController(applicationContext)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recycler_view)

        button.setOnClickListener {
            newNote()
        }
        recyclerView.adapter = CustomAdapter(noteController.getNotes(), noteController, this, this)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))
    }

}