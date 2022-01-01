package com.example.sensores.view

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sensores.R

class SensorActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var mSensorManager: SensorManager
    private lateinit var currentSensor: Sensor
    private lateinit var textViewSensor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        textViewSensor = findViewById(R.id.text_view)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorType = intent.getSerializableExtra("sensor").toString().toInt()
        currentSensor = mSensorManager.getDefaultSensor(sensorType)
        mSensorManager.registerListener(this, currentSensor, SensorManager.SENSOR_DELAY_NORMAL)

    }


    override fun onSensorChanged(event: SensorEvent?) {
        val currentValue: Float = event!!.values[0]
        textViewSensor.text = currentValue.toString()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

}