package com.example.registro.menusito1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.registro.Menu_verdadero
import com.example.registro.R
import com.example.registro.menuApp

class AjustesFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ajustes, container, false)

        // Apply window insets for edge-to-edge compatibility
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Button to navigate to menuApp activity
        val cambiarPantalla7: Button = view.findViewById(R.id.textView5)
        cambiarPantalla7.setOnClickListener {
            val intent = Intent(requireContext(),Menu_verdadero::class.java)
            startActivity(intent)
        }

        // Button to show a Toast message
        val guardado: Button = view.findViewById(R.id.textView4)
        guardado.setOnClickListener {
            Toast.makeText(requireContext(), "🌈Guardado con Éxito🌈", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    companion object {
        /**
         * Factory method to create a new instance of this fragment
         */
        @JvmStatic
        fun newInstance() = AjustesFragment()
    }
}
