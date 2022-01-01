package com.example.sensores.view

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sensores.R
import com.example.sensores.adapter.CustomAdapter

class MainActivity : AppCompatActivity(){

    private lateinit var mSensorManager: SensorManager
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        val listSensor: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)

        recyclerView.adapter = CustomAdapter(listSensor,applicationContext,this)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))

    }
}