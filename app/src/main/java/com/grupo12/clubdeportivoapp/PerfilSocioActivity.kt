package com.grupo12.clubdeportivoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.grupo12.clubdeportivoapp.databinding.ActivityPerfilSocioBinding

class PerfilSocioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPerfilSocioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilSocioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Socio hardcodeado con todos los campos requeridos
        val socioHardcodeado = Socio(
            nombre = "Juan",
            apellido = "Pérez",
            dni = "12345678",
            telefono = "555-1234",
            email = "juan.perez@example.com",
            fechaNacimiento = "01/01/1980",
            asociado = true,
            vencimiento = "31/12/2023"
        )

        with(binding) {
            // Botón Atrás
            btnBack.setOnClickListener {
                finish()
            }

            // Botón Editar
            btnEditar.setOnClickListener {
                mostrarMensaje("Funcionalidad de edición en desarrollo")
            }

            // Botón Ver Clases - Navega a MantenimientoActivity
            btnVerClases.setOnClickListener {
                startActivity(Intent(this@PerfilSocioActivity, MantenimientoActivity::class.java))
            }

            // Botón Guardar - Muestra mensaje de éxito
            btnGuardar.setOnClickListener {
                Toast.makeText(
                    this@PerfilSocioActivity,
                    "Actualizado con éxito",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Botón Registrar Pago - Navega a RegistrarPagoActivity
            btnRegistrarPago.setOnClickListener {
                startActivity(
                    Intent(this@PerfilSocioActivity, RegistrarPagoActivity::class.java).apply {
                        putExtra("socio", socioHardcodeado)
                    }
                )
            }

            // Mostrar datos del socio
            tvNombre.text = "${socioHardcodeado.nombre} ${socioHardcodeado.apellido}"
            tvDni.text = "DNI: ${socioHardcodeado.dni}"
        }
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}