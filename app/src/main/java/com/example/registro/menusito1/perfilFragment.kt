package com.example.registro.menusito1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.registro.R
import com.example.registro.databinding.FragmentPerfilBinding
import com.example.registro.menuApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val view = binding.root

        // Apply window insets for edge-to-edge compatibility
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.main5)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Handle sign out
        binding.salirBoton.setOnClickListener {
            signOut()
        }

        // Retrieve arguments
        val nombre = arguments?.getString("nombre") ?: "Nombre no disponible 😢"
        val gmail = arguments?.getString("gmail") ?: "Gmail no disponible 🤷‍♂️"

        // Display data
        binding.textViewNombre.text = nombre
        binding.textViewGmail.text = gmail


        return view
    }

    private fun signOut() {
        auth.signOut()
        Toast.makeText(requireContext(), "Sesión Cerrada", Toast.LENGTH_SHORT).show()
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Factory method to create a new instance of this fragment
         */
        @JvmStatic
        fun newInstance(nombre: String, gmail: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString("nombre", nombre)
                    putString("gmail", gmail)
                }
            }
    }
}
