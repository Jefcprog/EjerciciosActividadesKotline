package com.example.ejerciciosactividades

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContadorActivity : AppCompatActivity() {
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contador)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_contador)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnClic = findViewById<Button>(R.id.btnClic)
        val tvContador = findViewById<TextView>(R.id.tvContador)

        btnClic.setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }
    }
}