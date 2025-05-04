package com.grupo12.clubdeportivoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.grupo12.clubdeportivoapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupOverdueMembersList()
        setupButtonClickListeners()
    }

    private fun setupOverdueMembersList() {
        val overdueMembers = listOf(
            "Socio 1 - Vence: 01/05/2025",
            "Socio 2 - Vence: 02/05/2025",
            "Socio 3 - Vence: 03/05/2025"
        )

        binding.lvCuotasAtrasadas.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            overdueMembers
        )
    }

    private fun setupButtonClickListeners() {
        binding.btnRegistrarSocio.setOnClickListener {
            // Lógica para registrar socio
        }

        binding.btnRegistrarPago.setOnClickListener {
            // Lógica para registrar pago
        }

        binding.btnReporteVencimientos.setOnClickListener {
            // Lógica para reportes
        }

        binding.btnHistorialCobros.setOnClickListener {
            // Lógica para historial
        }
    }
}