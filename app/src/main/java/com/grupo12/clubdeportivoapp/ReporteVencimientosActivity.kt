package com.grupo12.clubdeportivoapp

import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReporteVencimientosActivity : AppCompatActivity() {

    private lateinit var rvUsuarios: RecyclerView
    private lateinit var btnBack: Button
    private lateinit var btnGenerarPdf: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte_vencimientos)

        rvUsuarios = findViewById(R.id.rvUsuariosVencidos)
        btnBack = findViewById(R.id.btnBack)
        btnGenerarPdf = findViewById(R.id.btnGenerarPdf)

        btnBack.setOnClickListener {
            finish()
        }

        btnGenerarPdf.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setMessage("Generando archivo PDF...")
                .setCancelable(false)
                .create()
            dialog.show()

            Handler(Looper.getMainLooper()).postDelayed({
                dialog.dismiss()
                Toast.makeText(this, "PDF generado correctamente", Toast.LENGTH_SHORT).show()
            }, 2000) // 2 segundos
        }

        // Dummy data: lista simple de strings con nombres
        val usuariosDummy = listOf(
            "Juan Pérez",
            "María Gómez",
            "Carlos Rodríguez",
            "Lucía Fernández",
            "Diego Martínez"
        )

        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = SimpleStringAdapter(usuariosDummy)
    }
}