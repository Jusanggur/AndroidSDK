package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private lateinit var textViewNome2: TextView
    private lateinit var textViewPeso2: TextView
    private lateinit var textViewAltura2: TextView
    private lateinit var textViewIMC2: TextView
    private lateinit var textViewResultado2: TextView
    private lateinit var imageView2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        textViewNome2 = findViewById(R.id.textViewNome2)
        textViewPeso2 = findViewById(R.id.textViewPeso2)
        textViewAltura2 = findViewById(R.id.textViewAltura2)
        textViewIMC2 = findViewById(R.id.textViewIMC2)
        textViewResultado2 = findViewById(R.id.textViewResultado2)
        imageView2 = findViewById(R.id.imageView2)

        //recebendo os valores informados na outra activity
        textViewNome2.text = intent.getSerializableExtra("nome").toString()
        textViewPeso2.text = intent.getSerializableExtra("peso").toString()
        textViewAltura2.text = intent.getSerializableExtra("altura").toString()
        var imc1 = intent.getSerializableExtra("imc").toString().toFloat()
        val dec = DecimalFormat("##.00")
        textViewIMC2.text = dec.format(imc1)

        //recebendo o imc
        val imc = intent.getSerializableExtra("imc").toString().toFloat()

        //baseado no imc recebido
        when {
            imc>=40 -> {
                textViewResultado2.text = "Obesidade III (Mórbida)"
                imageView2.setImageResource(R.drawable.obesidade3)
            }
            imc>=35 -> {
                textViewResultado2.text = "Obesidade II (Severa)"
                imageView2.setImageResource(R.drawable.obesidade2)
            }
            imc>=30 -> {
                textViewResultado2.text = "Obesidade I"
                imageView2.setImageResource(R.drawable.obesidade1)
            }
            imc>=25 -> {
                textViewResultado2.text = "Levemente acima do peso"
                imageView2.setImageResource(R.drawable.sobrepeso)
            }
            imc>=18.6 -> {
                textViewResultado2.text = "Peso ideal"
                imageView2.setImageResource(R.drawable.normal)
            }
            else -> {
                textViewResultado2.text = "Abaixo do peso"
                imageView2.setImageResource(R.drawable.abaixopeso)
            }
        }

    }
}