package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNome: EditText
    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcularIMC: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNome = findViewById(R.id.editTextNome)
        editTextPeso = findViewById(R.id.editTextPeso)
        editTextAltura = findViewById(R.id.editTextAltura)
        buttonCalcularIMC = findViewById(R.id.buttonCalcularIMC)

        //se haver algum campo vazio deve retornar um toast de erro
        buttonCalcularIMC.setOnClickListener {
            if(verificar()){
                changeActivity()
            }else{
                Toast.makeText(this, "Alguns dos campos estão vazio", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //iniciando nova activity
    private fun changeActivity() {
        val intent = Intent(this, ImcActivity::class.java).apply {
            putExtra("nome", editTextNome.text.toString())
            putExtra("peso", editTextPeso.text.toString())
            putExtra("altura", editTextAltura.text.toString())
            putExtra("imc", calcular())
        }
        startActivity(intent)
    }
    //verifica se nao a um valor vazio entre os informados
    private fun verificar(): Boolean{
        return when {
            editTextNome.text.isEmpty() -> {
                false
            }
            editTextPeso.text.isEmpty() -> {
                false
            }
            editTextAltura.text.isEmpty() -> {
                false
            }
            else -> true
        }
    }
    //calcula o imc baseado em um return
    private fun calcular(): Float{
        val peso = editTextPeso.text.toString().toFloat()
        val altura = editTextAltura.text.toString().toFloat()
        return peso / (altura * altura)
    }

}