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

        val socio = intent.getSerializableExtra("socio") as? Socio ?: run {
            finish()
            return
        }

        with(binding) {
            btnBack.setOnClickListener { finish() }
            btnEditar.setOnClickListener {
                mostrarMensaje("Funcionalidad de edición en desarrollo")
            }
            btnVerClases.setOnClickListener {
                startActivity(Intent(this@PerfilSocioActivity, MantenimientoActivity::class.java))
            }
            btnGuardar.setOnClickListener {
                Toast.makeText(
                    this@PerfilSocioActivity,
                    R.string.editado_correctamente,
                    Toast.LENGTH_SHORT
                ).show()
            }
            btnRegistrarPago.setOnClickListener {
                startActivity(
                    Intent(this@PerfilSocioActivity, RegistrarPagoActivity::class.java).apply {
                        putExtra("socio", socio)
                    }
                )
            }

            tvNombre.text = "${socio.nombre} ${socio.apellido}"
            tvDni.text = "DNI: ${socio.dni}"
        }
    }

    private fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}