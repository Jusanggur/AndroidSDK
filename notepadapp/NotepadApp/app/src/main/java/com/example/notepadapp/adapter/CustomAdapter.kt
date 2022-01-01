package com.example.notepadapp.adapter


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.notepadapp.R
import com.example.notepadapp.controller.NoteController
import com.example.notepadapp.model.Note
import com.example.notepadapp.view.ActivityEditNote
import com.example.notepadapp.view.ActivityNewNote
import com.example.notepadapp.view.ActivityOpenedNote

class CustomAdapter(
    private val notas: ArrayList<Note>,
    private val noteController: NoteController,
    private val context: Context,
    private val activity: Activity
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.item_tittle)
        var endIcon: ImageButton = view.findViewById(R.id.end_icon)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.adapter_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = notas[position].tittle
        var currentNote: Note = notas[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ActivityOpenedNote::class.java).apply {
                putExtra("id", currentNote.id)
                putExtra("tittle", currentNote.tittle)
                putExtra("description", currentNote.description)
            }
            activity.startActivity(intent)
        }

        holder.itemView.setOnLongClickListener {
            holder.endIcon.visibility = View.VISIBLE
            holder.endIcon.setImageResource(R.drawable.ic_delete)
            holder.endIcon.setOnClickListener {
                noteController.removeNote(currentNote.id!!)
            }
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount() = notas.size

}