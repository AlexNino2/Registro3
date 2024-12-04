package com.example.registro

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registro.databinding.ActivityMenuAppBinding
import com.example.registro.menusito1.perfilFragment

class Menu_verdadero : AppCompatActivity() {
    private lateinit var binding: ActivityMenuAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMenuAppBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if ( savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                perfilFragment()
            ).commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { when(it.itemId){
            R.id.perfil -> {supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                perfilFragment()
            ).commit()
            true}

            else -> false


            }
        }







    }
}