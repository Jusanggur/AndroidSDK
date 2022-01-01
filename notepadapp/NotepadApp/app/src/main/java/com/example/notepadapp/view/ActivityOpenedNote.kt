package com.example.notepadapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.notepadapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityOpenedNote : AppCompatActivity() {

    private lateinit var tittleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var editButton: FloatingActionButton
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opened_note)

        tittleTextView = findViewById(R.id.tittle_opened_note)
        descriptionTextView = findViewById(R.id.text_view_description)
        editButton = findViewById(R.id.edit_button)
        toolbar = findViewById(R.id.toolbar)


        tittleTextView.text = intent.getSerializableExtra("tittle").toString()
        descriptionTextView.text = intent.getSerializableExtra("description").toString()

        toolbar.setNavigationOnClickListener {
            this.onBackPressed()
        }

        editButton.setOnClickListener {
            val newIntent = Intent(this, ActivityEditNote::class.java).apply {
                putExtra("id", intent.getSerializableExtra("id").toString())
                putExtra("tittle", intent.getSerializableExtra("tittle").toString())
                putExtra("description", intent.getSerializableExtra("description").toString())
            }
            startActivity(newIntent)
        }
    }
}