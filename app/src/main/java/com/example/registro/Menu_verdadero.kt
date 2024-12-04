package com.example.registro

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registro.databinding.ActivityMenuVerdaderoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.example.registro.menusito1.AlarmaFragment
import com.example.registro.menusito1.PerfilFragment
import com.example.registro.menusito1.AjustesFragment


class Menu_verdadero : AppCompatActivity() {
    private lateinit var binding: ActivityMenuVerdaderoBinding
    //private lateinit var auth: FirebaseAuth

    //private lateinit var binding: ActivityMenuAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMenuVerdaderoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //auth = FirebaseAuth.getInstance()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AlarmaFragment()).commit()
        }

        binding.menusito.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.perfil1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, PerfilFragment()).commit()
                    true}

                R.id.configuracion1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AjustesFragment()).commit()
                    true}

                R.id.alarma -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AlarmaFragment()).commit()
                    true}

                else -> false
            }
        }
    }
}