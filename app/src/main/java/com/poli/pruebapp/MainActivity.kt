package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.poli.pruebapp.EmptyActivity
import com.poli.pruebapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los EditTexts y botones
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val registerButton = findViewById<Button>(R.id.registerButton)

        // Acción del botón de login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validación de credenciales
            if (email == "admin" && password == "123") {
                // Inicio de sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Redirigir a la nueva actividad vacía
                val intent = Intent(this, EmptyActivity::class.java)
                startActivity(intent)

                // Finalizar la actividad de login si deseas que no pueda regresar al login
                finish()
            } else {
                // Si los campos no son correctos, mostrar error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón de registro
        registerButton.setOnClickListener {
            // Redirigir a la actividad de registro
            Toast.makeText(this, "Redirigiendo a registro...", Toast.LENGTH_SHORT).show()



        }
    }
}
