package com.grupo12.clubdeportivoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.grupo12.clubdeportivoapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLoginButton()
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val isReceptionist = binding.rbRecepcionista.isChecked

            if (validateCredentials(username, password, isReceptionist)) {
                navigateToDashboard()
            } else {
                showError("Usuario, contraseña o rol incorrectos")
            }
        }
    }

    private fun validateCredentials(username: String, password: String, isReceptionist: Boolean): Boolean {
        return username == "recepcionista" && password == "1234" && isReceptionist
    }

    private fun showError(message: String) {
        binding.tvError.text = message
        binding.tvError.visibility = TextView.VISIBLE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToDashboard() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }
}