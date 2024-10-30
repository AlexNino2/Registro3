package com.example.registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main5)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre")
        val gmail = intent.getStringExtra("gmail")


        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewGmail = findViewById<TextView>(R.id.textViewGmail)

        textViewNombre.text = nombre ?: "Nombre no disponible 😢"
        textViewGmail.text = gmail ?: "Gmail no disponible🤷‍♂️"


        val cambiarPantalla6: Button = findViewById(R.id.salirBoton)
        cambiarPantalla6.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val cambiarPantalla7: Button = findViewById(R.id.regresoBoton)
        cambiarPantalla7.setOnClickListener {
            val intent = Intent(this, menuApp::class.java)
            startActivity(intent)
        }
    }
}
