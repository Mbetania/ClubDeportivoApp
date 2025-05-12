package com.grupo12.clubdeportivoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.grupo12.clubdeportivoapp.databinding.ActivityAddSocioBinding

class AddSocioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSocioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSocioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBackButton()
        setupRegisterButton()
    }

    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupRegisterButton() {
        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val apellido = binding.etApellido.text.toString()
            val dni = binding.etDni.text.toString()
            val telefono = binding.etTelefono.text.toString()

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Socio registrado: $nombre $apellido", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}