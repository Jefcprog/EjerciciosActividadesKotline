package com.example.ejerciciosactividades

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConversorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_conversor)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etKilos = findViewById<EditText>(R.id.etKilos)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)

        btnConvertir.setOnClickListener {
            val input = etKilos.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(this, "Ingresa un valor en kilos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val kilos = input.toDouble()
                val libras = kilos * 2.20462
                tvResultado.text = String.format("%.2f kg = %.2f lb", kilos, libras)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}