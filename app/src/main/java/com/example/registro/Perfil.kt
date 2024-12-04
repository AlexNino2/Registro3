package com.example.registro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registro.databinding.ActivityPerfilBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class Perfil : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")

    private lateinit var binding: ActivityPerfilBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main5)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        binding.salirBoton.setOnClickListener {
            signOut()
        }

        val nombre = intent.getStringExtra("nombre")
        val gmail = intent.getStringExtra("gmail")


        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewGmail = findViewById<TextView>(R.id.textViewGmail)

        textViewNombre.text = nombre ?: "Nombre no disponible 😢"
        textViewGmail.text = gmail ?: "Gmail no disponible🤷‍♂️"

        val cambiarPantalla7: Button = findViewById(R.id.regresoBoton)
        cambiarPantalla7.setOnClickListener {
            val intent = Intent(this, menuApp::class.java)
            startActivity(intent)
        }
    }

    private fun signOut() {
        Firebase.auth.signOut()
        Toast.makeText(this,"Sesion Cerrada", Toast.LENGTH_SHORT).show()
        finish()
    }
}



