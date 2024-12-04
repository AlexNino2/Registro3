package com.example.registro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cambiarPantalla: Button = findViewById(R.id.buttonRegistrarse)
        cambiarPantalla.setOnClickListener {
            val intent = Intent(this, InicioSesion::class.java)
            startActivity(intent)
        }

        val cambiarPantalla4: Button = findViewById(R.id.buttonInicioS)
        cambiarPantalla4.setOnClickListener {
            try {
                val gmail =  findViewById<EditText>(R.id.emailText).text.toString().trim()
                val contra = findViewById<EditText>(R.id.contraText).text.toString().trim()

                if (gmail.isEmpty()) {
                    Toast.makeText(this,"💋Ingresa el Gmail💋",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (contra.isEmpty()) {
                    Toast.makeText(this,"🔑Ingresa una contraseña🔑",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(gmail).matches()) {
                    Toast.makeText(this, "🍌🍆Ingresa correo valido🍆🍌", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                //val intent = Intent(this, menuApp::class.java)
                //startActivity(intent)

                val intent = Intent(this, Menu_verdadero::class.java)
                startActivity(intent)


            } catch (e: Exception) {
                Log.e("ErrorIniciarSesion","🍕🍕Error al iniciar sesion: ${e.message}🍕🍕")
                Toast.makeText(this,"🌜ocurrio un error, intenta de nuevo🌛", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
