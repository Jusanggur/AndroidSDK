package com.example.sensores.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sensores.R
import com.example.sensores.view.SensorActivity

class CustomAdapter(
    private val listSensor: List<Sensor>,
    private val context: Context,
    private val activity: Activity
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.item_tittle)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.adapter_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listSensor[position].name
        val currentSensor: Sensor = listSensor[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(context, SensorActivity::class.java).apply {
                putExtra(
                    "sensor", currentSensor.type
                )
            }
            activity.startActivity(intent)
        }
    }

    override fun getItemCount() = listSensor.size

}