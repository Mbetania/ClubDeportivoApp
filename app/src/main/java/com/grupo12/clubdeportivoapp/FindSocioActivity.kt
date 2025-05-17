package com.grupo12.clubdeportivoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.grupo12.clubdeportivoapp.databinding.ActivityFindSocioBinding

class FindSocio : AppCompatActivity() {

    private lateinit var binding: ActivityFindSocioBinding
    private val CODIGO_ACCESO_RAPIDO = "11111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindSocioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupWindowInsets()
        setupViews()
        loadInitialData()
    }

    private fun setupWindowInsets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                view.paddingLeft,
                systemBars.top,
                view.paddingRight,
                systemBars.bottom
            )
            insets
        }
    }

    private fun setupViews() {
        binding.btnBuscar.setOnClickListener {
            performSearch()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.lvResultados.setOnItemClickListener { _, _, position, _ ->
            selectSocio(position)
        }
    }

    private fun performSearch() {
        val searchQuery = binding.etBusqueda.text.toString().trim()

        if (searchQuery == CODIGO_ACCESO_RAPIDO) {
            navigateToFastPayment()
            return
        }

        if (searchQuery.isEmpty()) {
            Toast.makeText(this, "Ingrese un nombre o DNI para buscar", Toast.LENGTH_SHORT).show()
        } else {
            val results = filterSocios(searchQuery)
            displayResults(results)
        }
    }

    private fun navigateToFastPayment() {
        Intent(this, RegistrarPagoActivity::class.java).apply {
            putExtra("modo_rapido", true)
            putExtra("nombre_socio", "Acceso Rápido")
            putExtra("dni_socio", CODIGO_ACCESO_RAPIDO)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }.also { startActivity(it) }
    }

    private fun filterSocios(query: String): List<String> {
        val sampleData = listOf(
            "Juan Pérez - DNI: 12345678",
            "María García - DNI: 87654321",
            "Carlos López - DNI: 45678912",
            "Ana Martínez - DNI: 32165498"
        )

        return sampleData.filter { it.contains(query, ignoreCase = true) }
    }

    private fun displayResults(results: List<String>) {
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            results
        )
        binding.lvResultados.adapter = adapter
    }

    private fun selectSocio(position: Int) {
        val selectedItem = binding.lvResultados.adapter.getItem(position) as String
        val dni = extractDniFromString(selectedItem)
        navigateToSocioProfile(dni)
    }

    private fun extractDniFromString(socioInfo: String): String {
        return socioInfo.split("DNI:")[1].trim()
    }

    private fun navigateToSocioProfile(dni: String) {
        Intent(this, PerfilSocioActivity::class.java).apply {
            putExtra("EXTRA_DNI", dni)
            startActivity(this)
        }
    }

    private fun loadInitialData() {
        binding.lvResultados.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            emptyList<String>()
        )
    }
}