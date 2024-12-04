package com.example.registro.menusito1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.registro.R

class AlarmaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alarma, container, false)

        // Find views and set listeners
        val prendio: Button = view.findViewById(R.id.textView2)
        prendio.setOnClickListener {
            Toast.makeText(requireContext(), "💢Alarma Encendida💢", Toast.LENGTH_SHORT).show()
        }

        val apagao: Button = view.findViewById(R.id.buttonApagao)
        apagao.setOnClickListener {
            Toast.makeText(requireContext(), "💤❤Alarma Apagada❤💤", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    companion object {
        /**
         * Factory method to create a new instance of this fragment
         */
        @JvmStatic
        fun newInstance() = AlarmaFragment()
    }
}
