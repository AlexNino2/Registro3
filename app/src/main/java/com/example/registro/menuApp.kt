package com.example.registro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registro.databinding.ActivityMenuAppBinding




class menuApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()



        setContentView(R.layout.activity_menu_app)

        val mainView = findViewById<View>(R.id.main3)

        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre")
        val gmail = intent.getStringExtra("gmail")


        val cambiarPantalla5: Button = findViewById(R.id.textView4)
        cambiarPantalla5.setOnClickListener {
            val intentPerfil = Intent(this,Perfil::class.java)
            intentPerfil.putExtra("nombre", nombre)
            intentPerfil.putExtra("gmail", gmail)
            startActivity(intentPerfil)

        }

        val cambiarPantalla9: Button = findViewById(R.id.textView3)
        cambiarPantalla9.setOnClickListener {
            val intent = Intent(this,Ajustes::class.java)
            startActivity(intent)
        }

        val prendio:Button = findViewById(R.id.textView2)
        prendio.setOnClickListener {
            Toast.makeText(this,"💢Alarma Encendida💢",Toast.LENGTH_SHORT).show()
        }

        val apagao:Button = findViewById(R.id.buttonApagao)
        apagao.setOnClickListener {
            Toast.makeText(this,"💤❤Alarma Apagada❤💤",Toast.LENGTH_SHORT).show()
        }




    }
}
