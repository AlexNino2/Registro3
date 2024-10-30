package com.example.registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ajustes : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajustes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cambiarPantalla7: Button = findViewById(R.id.textView5)
        cambiarPantalla7.setOnClickListener {
            val intent = Intent(this,menuApp::class.java)
            startActivity(intent)
        }
        val guardado = findViewById<Button>(R.id.textView4)
        guardado.setOnClickListener {
            Toast.makeText(this,"🌈Guardado con Exito🌈",Toast.LENGTH_SHORT).show()
        }




    }
}