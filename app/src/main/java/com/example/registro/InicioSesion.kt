package com.example.registro

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )


        enableEdgeToEdge()


        setContentView(R.layout.activity_inicio_sesion)


        val mainView = findViewById<View>(R.id.main2)


        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets
        }
        val cambiarPantalla2: Button = findViewById(R.id.buttonRegistrar)
        cambiarPantalla2.setOnClickListener {
            try {

                val nombre = findViewById<EditText>(R.id.nombreText).text.toString().trim()
                val gmail = findViewById<EditText>(R.id.emailText).text.toString().trim()
                val contra = findViewById<EditText>(R.id.contraText).text.toString().trim()
                val conContra = findViewById<EditText>(R.id.confirmContra).text.toString().trim()
                val checkBoxTerminos = findViewById<CheckBox>(R.id.checkBoxTerminos)


                if (nombre.isEmpty()) {
                    Toast.makeText(this, "👀Ingresa tu Nombre👀", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (!nombre.all { it.isLetter() || it.isWhitespace() }) {
                    Toast.makeText(this, "😲El nombre no puede contener números😲", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                if (gmail.isEmpty()) {
                    Toast.makeText(this, "🤑Ingresa el Gmail🤑", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(gmail).matches()) {
                    Toast.makeText(this, "🤬Ingresa un correo válido🤬", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                if (contra.isEmpty()) {
                    Toast.makeText(this, "🤠Ingresa una contraseña🤠", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (conContra.isEmpty()) {
                    Toast.makeText(this, "🥵Confirma tu contraseña🥵", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (contra != conContra) {
                    Toast.makeText(this, "🤡Las contraseñas no coinciden🤡", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                if (!checkBoxTerminos.isChecked) {
                    Toast.makeText(this, "👹Debes aceptar los términos y condiciones👹", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val intentMenu = Intent(this, Menu_verdadero::class.java)
                intentMenu.putExtra("nombre", nombre)
                intentMenu.putExtra("gmail", gmail)
                startActivity(intentMenu)

            } catch (e: Exception) {
                Log.e("ErrorRegistro", "💩Error al Registrarse: ${e.message}💩")
                Toast.makeText(this, "🤰Ocurrió un error, intenta de nuevo🤰", Toast.LENGTH_SHORT).show()
            }
        }


        val cambiarPantalla3: Button = findViewById(R.id.buttonVolver)
        cambiarPantalla3.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
